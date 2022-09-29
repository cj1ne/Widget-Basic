package com.glen.widget_basic.configure

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glen.widget_basic.databinding.WidgetConfigureItemViewBinding

class WidgetConfigureItemViewHolder(
    parent: ViewGroup,
    private val onClick: (String) -> Unit,
    private val binding: WidgetConfigureItemViewBinding = WidgetConfigureItemViewBinding.inflate(LayoutInflater.from(parent.context))
): RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener { onClick(binding.root.text.toString()) }
    }

    fun onBind(name: String) {
        binding.root.text = name
    }
}
