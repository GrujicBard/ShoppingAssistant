package com.example.tzva_naloga_1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.entities.ItemEntity

class RecyclerViewAdapter(private val listener: RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    var items  = ArrayList<ItemEntity>()

    fun setListData(data: ArrayList<ItemEntity>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ItemViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }

    class ItemViewHolder(view: View, private val listener: RowClickListener): RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.tv_rv_item);

        fun bind(data: ItemEntity) {
            val fullText = data.EAN +" "+ data.title +" "+ data.IsFavoriteItem +" "+ data.IsOnShoppingList +" "+ data.dateOfStorage +" "+ data.description +" "+ data.isStoredCold +" "+ data.price +" "+ data.quantity +" "+ data.uid
            txtName.text = fullText;
        }
    }

    interface RowClickListener{
        fun onDeleteItemClickListener(item: ItemEntity)
        fun onItemClickListener(item: ItemEntity)
    }
}