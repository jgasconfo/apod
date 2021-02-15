package net.chuskis.apod.ui.list

import androidx.recyclerview.widget.DiffUtil
import net.chuskis.apod.model.responses.Apod

class DiffUtils : DiffUtil.ItemCallback<Apod>() {

    override fun areItemsTheSame(oldItem: Apod, newItem: Apod): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: Apod, newItem: Apod): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.explanation == newItem.explanation &&
                oldItem.date == newItem.date &&
                oldItem.url == newItem.url
    }

}