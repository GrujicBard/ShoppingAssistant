package com.example.tzva_naloga_1.ui.dialog_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.*
import com.example.tzva_naloga_1.database.entities.ItemEntity

class FavoriteItemDialogFragment(var item: ItemEntity) : DialogFragment() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val view: View = inflater.inflate(R.layout.dialog_item_info, container, false);

        //Text Views
        val tv_name_dg: TextView = view.findViewById(R.id.tv_name_dg);
        val tv_ean_dg: TextView = view.findViewById(R.id.tv_ean_dg);
        val tv_shop_dg: TextView = view.findViewById(R.id.tv_shop_dg);
        val tv_quantity_dg: TextView = view.findViewById(R.id.tv_quantity_dg);
        val tv_price_dg: TextView = view.findViewById(R.id.tv_price_dg);
        val tv_stock_dg: TextView = view.findViewById(R.id.tv_stock_dg);
        val tv_description_dg: TextView = view.findViewById(R.id.tv_description_dg);

        //Buttons
        val btn_stock_minus: ImageButton = view.findViewById(R.id.btn_stock_minus);
        val btn_stock_plus: ImageButton = view.findViewById(R.id.btn_stock_plus);
        val btn_shopping_dg: ImageButton = view.findViewById(R.id.btn_shopping_dg);
        val btn_favorite_dg: ImageButton = view.findViewById(R.id.btn_favorite_dg);
        val btn_close: Button = view.findViewById(R.id.btn_close);

        //Image
        val iv_pic_dg: ImageView = view.findViewById(R.id.iv_pic_dg);
        tv_name_dg.text = item.name
        tv_ean_dg.text = item.EAN
        tv_shop_dg.text = item.shop
        tv_quantity_dg.text = item.quantity
        tv_price_dg.text = resources.getString(R.string.currency, item.price);
        tv_stock_dg.text = item.stock.toString()
        tv_description_dg.text = item.description

        //Item
        var stock = item.stock
        var shopping = item.IsOnShoppingList
        var favorite = item.IsFavoriteItem

        //Listeners
        btn_stock_minus.setOnClickListener{
            stock--
            tv_stock_dg.text = stock.toString()
        }
        btn_stock_plus.setOnClickListener{
            stock++
            tv_stock_dg.text = stock.toString()
        }
        btn_shopping_dg.setOnClickListener {
            if(shopping){
                shopping = false
                btn_shopping_dg.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
            }else{
                shopping = true
                btn_shopping_dg.setImageResource(R.drawable.ic_baseline_remove_shopping_cart_24)
            }
        }
        btn_favorite_dg.setOnClickListener{
            if(favorite){
                favorite = false
                btn_favorite_dg.setImageResource(R.drawable.ic_baseline_favorite_24)
            }else{
                favorite = true
                btn_favorite_dg.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
        btn_close.setOnClickListener{ //Update item on close
            item.stock = stock
            item.IsOnShoppingList = shopping
            item.IsFavoriteItem = favorite
            itemViewModel.updateItem(item)
            dismiss();
        };

        if (item.IsOnShoppingList) {
            btn_shopping_dg.setImageResource(R.drawable.ic_baseline_remove_shopping_cart_24)
        } else {
            btn_shopping_dg.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
        }

        if (item.IsFavoriteItem) {
            btn_favorite_dg.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        } else {
            btn_favorite_dg.setImageResource(R.drawable.ic_baseline_favorite_24)
        }

        return view;

    }
}