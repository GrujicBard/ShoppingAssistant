package com.example.tzva_naloga_1.adapters

import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.ItemViewModel
import com.example.tzva_naloga_1.database.ItemViewModelFactory
import com.example.tzva_naloga_1.database.ItemsApplication
import com.example.tzva_naloga_1.database.entities.ItemEntity
import android.view.MenuInflater as menu

class ItemListAdapter(
    private val onItemClickListener: OnItemClickListener,
    //val onItemLongClickListener: OnItemLongClickListener,
    private val itemViewModel: ItemViewModel,
    //private val showMenuDelete: (Boolean) -> Unit,
) :
    ListAdapter<ItemEntity, ItemListAdapter.ItemViewHolder>(ItemDiffCallback()) {
    private var isEnable = false
    private var isSelectAll = false
    private var itemSelectedList = mutableListOf<Int>()

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
            /* itemView.setOnLongClickListener {
                val position = adapterPosition
                onItemLongClickListener.onItemLongClick(getItem(position))
                true
            }*/
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        val item_name = item.name + ", " + item.quantity
        holder.apply {
            rv_tv_name.text = item_name
            rv_tv_stock.text =
                itemView.resources.getString(R.string.rv_stock, item.stock.toString())
            itemView.setOnLongClickListener {
                selectItem(holder, item, position)
                Log.d("TEST", "LONG CLIIIIIIIIIIIIIICK")
                true
            }
        }
    }

    private fun selectItem(holder: ItemListAdapter.ItemViewHolder, item: ItemEntity, position: Int) {
        isEnable = true
        itemSelectedList.add(position)
        item.selected = true
        //showMenuDelete(true)
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