package com.example.tzva_naloga_1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.entities.UserEntity
import org.w3c.dom.Text

class RecyclerViewAdapter(private val listener: RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder>() {

    var items  = ArrayList<UserEntity>()

    fun setListData(data: ArrayList<UserEntity>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return UserViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])

    }



    class UserViewHolder(view: View, private val listener: RowClickListener): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.tv_rv_item);



        fun bind(data: UserEntity) {
            val fullName = data.name +" "+ data.surname;
            name.text = fullName;

        }
    }

    interface RowClickListener{
        fun onDeleteUserClickListener(user: UserEntity)
        fun onItemClickListener(user: UserEntity)
    }
}