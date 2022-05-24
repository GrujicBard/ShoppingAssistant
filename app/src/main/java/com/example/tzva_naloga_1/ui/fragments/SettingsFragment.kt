package com.example.tzva_naloga_1.ui.fragments
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tzva_naloga_1.ui.MainActivity
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.*
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
            itemViewModel.deleteAllItems(); //TO DO: Are you sure? Y/N
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
}