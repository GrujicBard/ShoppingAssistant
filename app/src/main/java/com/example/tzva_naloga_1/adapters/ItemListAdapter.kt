package com.example.tzva_naloga_1.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.entities.ItemEntity



class ItemListAdapter(val onItemClickListener : OnItemClickListener) :
    ListAdapter<ItemEntity, ItemListAdapter.ItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ItemViewHolder(inflater.inflate(R.layout.recyclerview_item, parent, false))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rv_tv_name: TextView = itemView.findViewById(R.id.rv_tv_name);
        val rv_tv_stock: TextView = itemView.findViewById(R.id.rv_tv_stock);

        init{
            itemView.setOnClickListener {
                val position = adapterPosition
                onItemClickListener.onItemClick(getItem(position))
            }
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply{
            rv_tv_name.text = item.name
            rv_tv_stock.text = itemView.resources.getString(R.string.rv_stock, item.stock.toString())
        }
    }
    interface OnItemClickListener {
        fun onItemClick(item: ItemEntity)
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<ItemEntity>() {
    override fun areItemsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean {
        return oldItem.itemId == newItem.itemId
    }

}