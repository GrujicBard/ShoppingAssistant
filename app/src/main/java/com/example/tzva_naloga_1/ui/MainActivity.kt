package com.example.tzva_naloga_1.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var mainMenu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val tabLayout : TabLayout = findViewById(R.id.tabLayout);
        val viewPager2 : ViewPager2 = findViewById(R.id.viewPager);
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle);


        viewPager2.adapter = adapter;
        TabLayoutMediator(tabLayout, viewPager2){tab, position ->
            when(position){
                0->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_storage_24, null );
                }
                1->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_add_24, null );
                }
                2->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_favorite_24, null );
                }
                3->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_shopping_cart_24, null );
                }
                4->{
                    tab.icon = ResourcesCompat.getDrawable(resources,
                        R.drawable.ic_baseline_settings_24, null );
                }
            }
        }.attach();
    }

    fun showDeleteMenu(show: Boolean){
        mainMenu?.findItem(R.id.menu_delete)?.isVisible = show
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        mainMenu = menu
        menuInflater.inflate(R.menu.custom_menu, mainMenu)
        showDeleteMenu(true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_delete -> { delete()}
        }
        return super.onOptionsItemSelected(item)
    }

    private fun delete() {
        TODO("Not yet implemented")
    }
}