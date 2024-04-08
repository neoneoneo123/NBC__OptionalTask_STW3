package com.example.nbc__standardtaskweek3_optional

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc__standardtaskweek3_optional.databinding.ItemBinding
import com.example.nbc__standardtaskweek3_optional.flowerData.Flower

class ItemAdapter(private val items: List<Flower>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class ItemViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Flower) {
            binding.tvItemName.text = item.name
            binding.tvItemDes.text = item.description
        }
    }
}