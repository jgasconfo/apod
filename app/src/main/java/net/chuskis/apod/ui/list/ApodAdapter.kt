package net.chuskis.apod.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import net.chuskis.apod.R
import net.chuskis.apod.model.responses.Apod

class ApodAdapter(private val onClick: (apod: Apod) -> Unit) :
    ListAdapter<Apod, ApodViewHolder>(DiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ApodViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_apod, parent, false)
        )

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

}