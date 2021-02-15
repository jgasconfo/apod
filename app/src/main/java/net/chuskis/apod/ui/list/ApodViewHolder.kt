package net.chuskis.apod.ui.list

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import net.chuskis.apod.R
import net.chuskis.apod.model.responses.Apod
import net.chuskis.apod.utils.Constants
import java.text.DateFormat
import java.text.SimpleDateFormat

class ApodViewHolder (view: View) :  RecyclerView.ViewHolder(view) {

    private val date = itemView.findViewById<AppCompatTextView>(R.id.date_text_view)
    private val title = itemView.findViewById<AppCompatTextView>(R.id.title_text_view)
    private val thumbnail = itemView.findViewById<AppCompatImageView>(R.id.image_thumb)

    fun bind(apod: Apod, onClick: (Apod) -> Unit) {
        title.text = apod.title
        date.text = getLocaleDate(apod.date)

        if (apod.media_type == Constants.MEDIA_TYPE_IMAGE) {
            thumbnail.load(apod.url)
        } else if (apod.media_type == Constants.MEDIA_TYPE_VIDEO) {

        }

        itemView.setOnClickListener { onClick.invoke(apod) }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getLocaleDate(serverDate: String) : String {
        val pattern = "yyyy-MM-dd"

        return try {
            val date = SimpleDateFormat(pattern).parse(serverDate)
            DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)
        } catch (e: Exception) {
            ""
        }
    }

}