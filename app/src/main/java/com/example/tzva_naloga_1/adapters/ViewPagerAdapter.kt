package com.example.tzva_naloga_1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tzva_naloga_1.ui.fragments.*

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        val numOfFragments = 5;
        return numOfFragments
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                DatabaseFragment()
            }
            1 -> {
                InputFragment()
            }
            2 -> {
                FavoritesFragment()
            }
            3 ->{
                ShoppingFragment()
            }
            4 ->{
                SettingsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}