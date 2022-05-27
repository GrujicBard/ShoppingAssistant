package com.example.tzva_naloga_1.ui.fragments
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tzva_naloga_1.ui.MainActivity
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.*
import com.example.tzva_naloga_1.database.entities.ItemCategory
import com.example.tzva_naloga_1.database.entities.ItemEntity
import com.example.tzva_naloga_1.database.entities.Shop
import com.example.tzva_naloga_1.database.entities.Storage
import java.util.*

class SettingsFragment : Fragment() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        loadLocale();
        val view = inflater.inflate(R.layout.fragment_settings, container, false);
        val btn_lang = view.findViewById<Button>(R.id.btn_lang);
        val btn_nuke = view.findViewById<Button>(R.id.btn_nuke);

        btn_lang.setOnClickListener{

            showChangeLang();
        };

        btn_nuke.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.setTitle("Do you want to reset database?")
            alertDialog.setPositiveButton("Reset"){_,_ ->{}
                itemViewModel.deleteAllItems();
                resetDatabase()
            }
            alertDialog.setNegativeButton("Cancel"){_,_ ->}
            alertDialog.show()
        };

        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showChangeLang() {
        val languages = arrayOf("eng", "sl");
        val builder = AlertDialog.Builder(context);

        builder.setTitle(resources.getString(R.string.header_3));
        builder.setSingleChoiceItems(languages, -1){ dialog, lang ->
            when(lang){
                0->{
                    setLocale("eng")
                    requireActivity().recreate();
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                }
                1->{
                    setLocale("sl")
                    requireActivity().recreate();
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            dialog.dismiss();
        }
        val dialog = builder.create();
        dialog.show();
    }

    @SuppressLint("CommitPrefEdits")
    private fun setLocale(lang: String) {
        val locale = Locale(lang);
        val config = Configuration();
        val editor = requireContext().getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();

        Locale.setDefault(locale);
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.displayMetrics);
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    private fun loadLocale(){
        val sharedPreferences = requireContext().getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        val language = sharedPreferences.getString("My_Lang", "");
        setLocale(language.toString());
    }

    private fun resetDatabase(){
        // Add sample items.
        val item1 = ItemEntity(
            0,
            "3838800024967",
            "Trajno polnomastno mleko, 3,5 % m.m., Mercator",
            1.09,
            "1L",
            6,
            Shop.MERCATOR.toString(),
            Storage.FREEZER.toString(),
            ItemCategory.MILK_EGGS_AND_DAIRY_PRODUCTS.toString(),
            description = "UHT polnomastno mleko z 3,5% mlečne maščobe."
        )
        itemViewModel.insertItem(item1)
        val item2 = ItemEntity(
            0,
            "1644800024357",
            "Jajca L, hlevska reja, Mercator",
            1.99,
            "10 jajc",
            3,
            Shop.MERCATOR.toString(),
            Storage.FREEZER.toString(),
            ItemCategory.MILK_EGGS_AND_DAIRY_PRODUCTS.toString(),
            description = "Jajca pred uporabo termično obdelati."
        )
        itemViewModel.insertItem(item2)
        val item3 = ItemEntity(
            0,
            "865080043657",
            "Slane palčke, Hrusty",
            0.17,
            "220g",
            1,
            Shop.MERCATOR.toString(),
            Storage.CUPBOARD.toString(),
            ItemCategory.SALTY_SNACKS.toString(),
            description = "PŠENIČNA moka, koruzni škrob, palmina maščoba, jodirana sol 2,5 % (sol, kalijev jodat), " +
                    "sladkor, emulgator: SOJIN lecitin; sredstva za vzhajanje: amonijevi karbonati; JEČMENOV slad, " +
                    "kvas, sredstvo za glaziranje: natrijev hidroksid.Lahko vsebuje sledi MLEKA, ARAŠIDOV in OREŠKOV." +
                    "Država porekla: Hrvaška.",
        )
        itemViewModel.insertItem(item3)
        val item4 = ItemEntity(
            0,
            "3831006616004",
            "Hrenovke piščančje IK, VP",
            3.49,
            "600g",
            2,
            Shop.TUŠ.toString(),
            Storage.FREEZER.toString(),
            ItemCategory.MEAT_PRODUCTS.toString(),
            description = "strojno izkoščeno piščanje meso 66%, voda, piščančje kožice, krompirjev škrob, grahova moka," +
                    " vlakna citrusov, jedilna sol, začimbe, stabilizatorja: E 450, E 451; dekstroza, antioksidant: " +
                    "E 316; konzervansa: E 250, E 262."
        )
        itemViewModel.insertItem(item4)
        val item5 = ItemEntity(
            0,
            "8596046616324",
            "WC čistilo Power Aktiv Gel Pine, Bref",
            1.78,
            "700ml",
            1,
            Shop.MERCATOR.toString(),
            Storage.BATHROOM.toString(),
            ItemCategory.CLEANING_PRODUCTS.toString(),
            description = "Slike so simbolične, ponudnik si pridržuje pravico do tipkarskih napak."
        )
        itemViewModel.insertItem(item5)
        val item6 = ItemEntity(
            0,
            "7485026612341",
            "Temno pivo Kozel, 3,8 %",
            1.23,
            "0,5L",
            12,
            Shop.SPAR.toString(),
            Storage.CELLAR.toString(),
            ItemCategory.ALCOHOL.toString(),
            description = "Voda, ječmenov slad, hmelj, hmeljni ekstrakt, sladkor.."
        )
        itemViewModel.insertItem(item6)
    }


}