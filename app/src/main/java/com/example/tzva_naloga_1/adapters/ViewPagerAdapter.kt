package com.example.tzva_naloga_1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tzva_naloga_1.ui.fragments.DatabaseFragment
import com.example.tzva_naloga_1.ui.fragments.InputFragment
import com.example.tzva_naloga_1.ui.fragments.SettingsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        val numOfFragments = 3;
        return numOfFragments
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                InputFragment()
            }
            1 -> {
                DatabaseFragment()
            }
            2 -> {
                SettingsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}