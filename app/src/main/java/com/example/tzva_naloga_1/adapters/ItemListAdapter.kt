package com.example.tzva_naloga_1.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
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
    private val owner: LifecycleOwner,
    //val onItemLongClickListener: OnItemLongClickListener,
    private var dataset: LiveData<MutableList<ItemEntity>>,
    private val itemViewModel: ItemViewModel,
    private val showMenuDelete: (Boolean) -> Unit,
) :
    ListAdapter<ItemEntity, ItemListAdapter.ItemViewHolder>(ItemDiffCallback()) {
    private var isEnable = false
    private var isSelectAll = false
    private var itemSelectedList = mutableListOf<Int>()
    private var itemsList: MutableList<ItemEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        dataset.observe(owner) { items ->
            submitList(items)
            itemsList = items
        }
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
                val item = getItem(position)
                if (itemSelectedList.contains(position)) {
                    itemSelectedList.remove(position)
                    if(rv_cb.visibility == View.VISIBLE){
                        rv_cb.visibility = View.GONE
                    }
                    itemsList?.get(position)?.selected  = false
                    if(itemSelectedList.isEmpty()){
                        showMenuDelete(false)
                        isEnable = false
                    }
                } else if (isEnable) {
                    selectItem(this, item, position)
                } else {
                    onItemClickListener.onItemClick(getItem(position))
                }
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
                true
            }
            if(!isEnable){
                rv_cb.visibility = View.GONE
            }
        }
    }

    private fun selectItem(
        holder: ItemListAdapter.ItemViewHolder,
        item: ItemEntity,
        position: Int,
    ) {
        isEnable = true
        itemSelectedList.add(position)
        itemsList?.get(position)?.selected = true
        if(holder.rv_cb.visibility == View.GONE){
            holder.rv_cb.visibility = View.VISIBLE
        }
        showMenuDelete(true)
    }

    fun deleteSelectedItem() { // ITEM SELECTED DELA AL NE DELA????
        if(itemSelectedList.isNotEmpty()){
            itemsList?.let { itemViewModel.updateItems(it) }
            itemViewModel.deleteAllItemsSelected()
            isEnable = false
            itemSelectedList.clear()
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