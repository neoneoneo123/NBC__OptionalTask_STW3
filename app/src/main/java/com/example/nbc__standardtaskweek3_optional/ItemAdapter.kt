package com.example.nbc__standardtaskweek3_optional

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc__standardtaskweek3_optional.databinding.ItemBinding
import com.example.nbc__standardtaskweek3_optional.flowerData.Flower

class ItemAdapter(private val items: List<Flower>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int) {

        }
    }

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

        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
                Log.d("여기는 아이텝 어댑터", "${adapterPosition}")
            }
        }

        fun bind(item: Flower) {
            binding.tvItemName.text = item.name
            binding.tvItemDes.text = item.description
        }
    }
}