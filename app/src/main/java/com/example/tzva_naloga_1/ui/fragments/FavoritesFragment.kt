package com.example.tzva_naloga_1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.ItemViewModel
import com.example.tzva_naloga_1.database.ItemViewModelFactory
import com.example.tzva_naloga_1.database.ItemsApplication

class FavoritesFragment : Fragment() {
    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false);


        return view;
    }
}