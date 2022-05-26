package com.example.tzva_naloga_1.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.entities.ItemEntity


class ItemListAdapter(val onItemClickListener: OnItemClickListener, val onItemLongClickListener: OnItemLongClickListener) :
    ListAdapter<ItemEntity, ItemListAdapter.ItemViewHolder>(ItemDiffCallback()) {

    var isEnable = false
    var isSelectAll = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ItemViewHolder(inflater.inflate(R.layout.recyclerview_item, parent, false))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rv_tv_name: TextView = itemView.findViewById(R.id.rv_tv_name);
        val rv_tv_stock: TextView = itemView.findViewById(R.id.rv_tv_stock);
        val rv_cb: ImageView = itemView.findViewById(R.id.rv_cb);

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                onItemClickListener.onItemClick(getItem(position))
            }
            itemView.setOnLongClickListener {
                val position = adapterPosition
                onItemLongClickListener.onItemLongClick(getItem(position))
                true
            }
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        val item_name = item.name + ", " + item.quantity
        holder.apply {
            rv_tv_name.text = item_name
            rv_tv_stock.text =
                itemView.resources.getString(R.string.rv_stock, item.stock.toString())
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: ItemEntity)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(item: ItemEntity)
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