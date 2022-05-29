package com.example.tzva_naloga_1.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.FavoriteListAdapter
import com.example.tzva_naloga_1.adapters.ItemListAdapter
import com.example.tzva_naloga_1.database.*
import com.example.tzva_naloga_1.database.entities.ItemCategorySearch
import com.example.tzva_naloga_1.database.entities.ItemEntity
import com.example.tzva_naloga_1.database.entities.ShopSearch
import com.example.tzva_naloga_1.database.entities.StorageSearch
import com.example.tzva_naloga_1.ui.dialog_fragments.FavoriteItemDialogFragment
import com.example.tzva_naloga_1.ui.dialog_fragments.ItemDialogFragment

class FavoritesFragment : Fragment(), FavoriteListAdapter.OnItemClickListener {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }
    private var favoriteListAdapter: FavoriteListAdapter? = null
    private var menu_delete: Menu? = null
    private var menu_select_all: Menu? = null
    private var menu_close: Menu? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_database, container, false);

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview);
        favoriteListAdapter = FavoriteListAdapter(this, viewLifecycleOwner, itemViewModel.allFavoriteItems, itemViewModel){ show -> showDeleteMenu(show) }


        recyclerView.adapter = favoriteListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
            items.let { favoriteListAdapter!!.submitList(it) }
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
                    0 -> favoriteListAdapter!!.submitList(items.filter { item -> item.storage == "Freezer" })
                    1 -> favoriteListAdapter!!.submitList(items.filter { item -> item.storage == "Cupboard" })
                    2 -> favoriteListAdapter!!.submitList(items.filter { item -> item.storage == "Bathroom" })
                    3 -> favoriteListAdapter!!.submitList(items.filter { item -> item.storage == "Cellar" })
                    4 -> favoriteListAdapter!!.submitList(items.filter { item -> item.storage.any() })
                }
            }
        }

        dd_shop.setOnItemClickListener{ _, _, position, _ ->
            itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
                when(position) {
                    0 -> favoriteListAdapter!!.submitList(items.filter { item -> item.shop == "Mercator" })
                    1 -> favoriteListAdapter!!.submitList(items.filter { item -> item.shop == "Spar" })
                    2 -> favoriteListAdapter!!.submitList(items.filter { item -> item.shop == "Lidl" })
                    4 -> favoriteListAdapter!!.submitList(items.filter { item -> item.shop == "Tuš" })
                    5 -> favoriteListAdapter!!.submitList(items.filter { item -> item.shop == "Hofer" })
                    6 -> favoriteListAdapter!!.submitList(items.filter { item -> item.shop.any() })
                }
            }
        }

        dd_category.setOnItemClickListener{ _, _, position, _ ->
            itemViewModel.allFavoriteItems.observe(viewLifecycleOwner) { items ->
                when(position) {
                    0 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Milk_eggs_and_dairy_products" })
                    1 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Meat_products" })
                    2 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Bread_and_pastries" })
                    3 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Frozen_food" })
                    4 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Soft_drinks" })
                    5 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Alcohol" })
                    6 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Soups_rice_and_sauces" })
                    7 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Salty_snacks" })
                    8 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category == "Cleaning_products" })
                    9 -> favoriteListAdapter!!.submitList(items.filter { item -> item.category.any() })
                }
            }
        }


        setHasOptionsMenu(true)
        return view;
    }
    //Open dialog on recyclerview Item click
    override fun onItemClick(item: ItemEntity) {
        val itemDialog = FavoriteItemDialogFragment(item)
        itemDialog.show(parentFragmentManager, "FavoriteItemDialog")
    }

    private fun showDeleteMenu(show: Boolean) {
        menu_delete?.findItem(R.id.menu_delete)?.isVisible = show
        menu_close?.findItem(R.id.menu_close)?.isVisible = show
        menu_select_all?.findItem(R.id.menu_select_all)?.isVisible = show
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu_delete = menu
        menu_close = menu
        menu_select_all = menu
        inflater.inflate(R.menu.custom_menu, menu_delete)
        showDeleteMenu(false)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_delete -> {
                delete()
            }
            R.id.menu_select_all ->{
                selectAll()
            }
            R.id.menu_close ->{
                close()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun delete() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(resources.getString(R.string.favoriteToast))
        alertDialog.setPositiveButton(resources.getString(R.string.confirm)){_,_ ->{}
            favoriteListAdapter!!.deleteSelectedItem()
            showDeleteMenu(false)
        }
        alertDialog.setNegativeButton(resources.getString(R.string.cancel)){_,_ ->}
        alertDialog.show()
    }

    private fun selectAll(){
        favoriteListAdapter!!.selectAll()
        if(favoriteListAdapter!!.isSelectAll()){
            menu_select_all!!.findItem(R.id.menu_select_all).setIcon(R.drawable.ic_baseline_deselect_24)
        }else if(!favoriteListAdapter!!.isSelectAll()){
            menu_select_all!!.findItem(R.id.menu_select_all).setIcon(R.drawable.ic_baseline_select_all_24)
        }
    }

    private fun close(){
        favoriteListAdapter!!.close()
        showDeleteMenu(false)
    }

    override fun onPause() {
        menu_select_all!!.findItem(R.id.menu_select_all).setIcon(R.drawable.ic_baseline_select_all_24)
        favoriteListAdapter!!.resetAdapter()
        super.onPause()
    }
}