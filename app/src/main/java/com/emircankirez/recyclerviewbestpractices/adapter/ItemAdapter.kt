package com.emircankirez.recyclerviewbestpractices.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emircankirez.recyclerviewbestpractices.databinding.ItemRowBinding
import com.emircankirez.recyclerviewbestpractices.model.Item

class ItemAdapter (private val itemList: ArrayList<Item>, private val listener : OnItemClickListener) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    // implement this wherever you use this adapter
    interface OnItemClickListener{
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }

    class ItemHolder (private val binding: ItemRowBinding, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root){
        // You need to implement onClick method here because it needs to run just while creating new holder, not binding viewHolder
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION)
                    listener.onItemClick(position)
            }

            itemView.setOnLongClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION)
                    listener.onItemLongClick(position)
                true
            }
        }

        fun bind(item: Item) {
            binding.apply {
                tvTitle.text = item.title
                tvContent.text = item.content
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemHolder(binding, listener)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(itemList[position])
    }
}