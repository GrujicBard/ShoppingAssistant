package com.example.tzva_naloga_1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.ItemListAdapter
import com.example.tzva_naloga_1.database.*

class DatabaseFragment : Fragment() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_database, container, false);

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview);
        val adapter = ItemListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel.allItems.observe(viewLifecycleOwner) { items ->
            items.let { adapter.submitList(it) }
        }

        return view;
    }
}