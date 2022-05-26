package com.example.tzva_naloga_1.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.ItemListAdapter
import com.example.tzva_naloga_1.database.*
import com.example.tzva_naloga_1.database.entities.ItemEntity
import com.example.tzva_naloga_1.ui.dialog_fragments.ItemDialogFragment

class DatabaseFragment : Fragment(), ItemListAdapter.OnItemClickListener {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }
    private var mainMenu: Menu? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_database, container, false);

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview);
        val adapter = ItemListAdapter(this, itemViewModel) //{ show -> showDeleteMenu(show) }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel.allItems.observe(viewLifecycleOwner) { items ->
            items.let { adapter.submitList(it) }
        }

        return view;
    }

    //Open dialog on recyclerview Item click
    override fun onItemClick(item: ItemEntity) {
        val itemDialog = ItemDialogFragment(item)
        itemDialog.show(parentFragmentManager, "ItemDialog")
    }

    /* override fun onItemLongClick(item: ItemEntity) {
        Toast.makeText(requireContext(), "Long click!", Toast.LENGTH_SHORT).show()
    }*/

    private fun showDeleteMenu(show: Boolean) {
        mainMenu?.findItem(R.id.menu_delete)?.isVisible = show
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        mainMenu = menu
        inflater.inflate(R.menu.custom_menu, mainMenu)
        showDeleteMenu(true)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_delete -> {
                delete()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun delete() {
        TODO("Not yet implemented")
    }
}