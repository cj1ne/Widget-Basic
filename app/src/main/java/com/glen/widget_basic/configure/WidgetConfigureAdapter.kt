package com.glen.widget_basic.configure

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class WidgetConfigureAdapter(
    private val onClick: (String) -> Unit
) : ListAdapter<String, WidgetConfigureItemViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return true
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetConfigureItemViewHolder {
        return WidgetConfigureItemViewHolder(parent, onClick)
    }

    override fun onBindViewHolder(holder: WidgetConfigureItemViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}
