package com.example.tzva_naloga_1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = resources.getString(R.string.header_1);

        val tabLayout : TabLayout = findViewById(R.id.tabLayout);
        val viewPager2 : ViewPager2 = findViewById(R.id.viewPager);
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle);

        viewPager2.adapter = adapter;
        TabLayoutMediator(tabLayout, viewPager2){tab, position ->
            when(position){
                0->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_home_24, null );
                }
                1->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_storage_24, null );
                }
                2->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_settings_24, null );
                }
            }
        }.attach();

    }
}