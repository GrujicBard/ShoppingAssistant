package com.example.tzva_naloga_1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.ItemListAdapter
import com.example.tzva_naloga_1.database.*
import com.example.tzva_naloga_1.database.entities.*
import com.example.tzva_naloga_1.ui.dialog_fragments.FavoriteItemDialogFragment
import com.example.tzva_naloga_1.ui.dialog_fragments.ItemDialogFragment

class FavoritesFragment : Fragment(), ItemListAdapter.OnItemClickListener, ItemListAdapter.OnItemLongClickListener {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_database, container, false);

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview);
        val adapter = ItemListAdapter(this, itemViewModel)



        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
            items.let { adapter.submitList(it) }
        }

        val dd_storage: AutoCompleteTextView = view.findViewById(R.id.dd_storage)
        dd_storage.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, StorageSearch.values()))

        val dd_shop: AutoCompleteTextView = view.findViewById(R.id.dd_shop)
        dd_shop.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, ShopSearch.values()))

        val dd_category: AutoCompleteTextView = view.findViewById(R.id.dd_category)
        dd_category.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, ItemCategorySearch.values()))

        dd_storage.setOnItemClickListener{ _, _, position, _ ->
            itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
                when(position) {
                    0 -> adapter.submitList(items.filter { item -> item.storage == "Freezer" })
                    1 -> adapter.submitList(items.filter { item -> item.storage == "Cupboard" })
                    2 -> adapter.submitList(items.filter { item -> item.storage == "Bathroom" })
                    3 -> adapter.submitList(items.filter { item -> item.storage == "Cellar" })
                    4 -> adapter.submitList(items.filter { item -> item.storage.any() })
                }
            }
        }

        dd_shop.setOnItemClickListener{ _, _, position, _ ->
            itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
                when(position) {
                    0 -> adapter.submitList(items.filter { item -> item.shop == "Mercator" })
                    1 -> adapter.submitList(items.filter { item -> item.shop == "Spar" })
                    2 -> adapter.submitList(items.filter { item -> item.shop == "Lidl" })
                    4 -> adapter.submitList(items.filter { item -> item.shop == "Tuš" })
                    5 -> adapter.submitList(items.filter { item -> item.shop == "Hofer" })
                    6 -> adapter.submitList(items.filter { item -> item.shop.any() })
                }
            }
        }

        dd_category.setOnItemClickListener{ _, _, position, _ ->
            itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
                when(position) {
                    0 -> adapter.submitList(items.filter { item -> item.category == "Milk_eggs_and_dairy_products" })
                    1 -> adapter.submitList(items.filter { item -> item.category == "Meat_products" })
                    2 -> adapter.submitList(items.filter { item -> item.category == "Bread_and_pastries" })
                    3 -> adapter.submitList(items.filter { item -> item.category == "Frozen_food" })
                    4 -> adapter.submitList(items.filter { item -> item.category == "Soft_drinks" })
                    5 -> adapter.submitList(items.filter { item -> item.category == "Alcohol" })
                    6 -> adapter.submitList(items.filter { item -> item.category == "Soups_rice_and_sauces" })
                    7 -> adapter.submitList(items.filter { item -> item.category == "Salty_snacks" })
                    8 -> adapter.submitList(items.filter { item -> item.category == "Cleaning_products" })
                    9 -> adapter.submitList(items.filter { item -> item.category.any() })
                }
            }
        }

        return view;
    }
    //Open dialog on recyclerview Item click
    override fun onItemClick(item: ItemEntity) {
        val itemDialog = FavoriteItemDialogFragment(item)
        itemDialog.show(parentFragmentManager, "FavoriteItemDialog")
    }

    override fun onItemLongClick(item: ItemEntity) {
        Toast.makeText(requireContext(), "Long click!", Toast.LENGTH_SHORT).show()
    }
}