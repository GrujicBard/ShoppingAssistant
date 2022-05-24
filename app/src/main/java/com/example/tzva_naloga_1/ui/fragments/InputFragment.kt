package com.example.tzva_naloga_1.ui.fragments

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.ItemViewModel
import com.example.tzva_naloga_1.database.ItemViewModelFactory
import com.example.tzva_naloga_1.database.ItemsApplication
import com.example.tzva_naloga_1.database.entities.ItemEntity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import org.json.JSONArray
import org.json.JSONObject

@Suppress("DEPRECATION")
class InputFragment : Fragment() {

    val database = Firebase.database
    val reference = database.getReference("")

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
        ): View? {

        val view : View = inflater.inflate(R.layout.fragment_input, container, false)
        val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
        val picker : MaterialDatePicker<*> = builder.build()

        //Item
        val et_EAN: EditText = view.findViewById(R.id.et_EAN)
        val et_title: EditText = view.findViewById(R.id.et_title)
        val et_description: EditText = view.findViewById(R.id.et_description)
        val et_price: EditText = view.findViewById(R.id.et_price)
        val et_quantity: EditText = view.findViewById(R.id.et_quantity)
        val et_dateOfStorage: EditText = view.findViewById(R.id.et_dateOfStorage)
        val cb_isStoredCold: CheckBox = view.findViewById(R.id.cb_isStoredCold)
        val cb_isFavoriteItem: CheckBox = view.findViewById(R.id.cb_isFavoriteItem)
        val cb_isOnShoppingList: CheckBox = view.findViewById(R.id.cb_isOnShoppingList)

        val success: String = getString(R.string.successfulCreation)
        val unSuccess: String = getString(R.string.unSuccessfulCreation)

        val btn_save : Button = view.findViewById(R.id.btn_save)
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        builder.setTitleText(resources.getString(R.string.calendar))
        et_dateOfStorage.setOnClickListener{
            picker.show(parentFragmentManager, picker.toString())
            imm.hideSoftInputFromWindow(et_dateOfStorage.windowToken, 0)
        }

        et_dateOfStorage.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                picker.show(parentFragmentManager, picker.toString())
                imm.hideSoftInputFromWindow(et_dateOfStorage.windowToken, 0)
            } else {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                    InputMethodManager.HIDE_IMPLICIT_ONLY)
            }
        }

        picker.addOnPositiveButtonClickListener {
            et_dateOfStorage.setText(picker.headerText)
            cb_isStoredCold.requestFocus()
        }

        btn_save.setOnClickListener{
            if(et_title.text.trim().length>0 &&
                et_quantity.text.trim().length>0)
            {
                val item = ItemEntity(
                    0,
                    et_EAN.text.toString(),
                    et_title.text.toString(),
                    et_dateOfStorage.text.toString(),
                    et_description.text.toString(),
                    et_price.text.toString().toDouble(),
                    et_quantity.text.toString().toInt(),
                    cb_isStoredCold.isChecked.toString().toBoolean(),
                    cb_isFavoriteItem.isChecked.toString().toBoolean(),
                    cb_isOnShoppingList.isChecked.toString().toBoolean()
                )
                Toast.makeText(activity?.application, success, Toast.LENGTH_SHORT).show()
                itemViewModel.insert(item)
            }
            else{
                Toast.makeText(activity?.application, unSuccess, Toast.LENGTH_SHORT).show()
            }
        }

        //pridobivanje podatkov iz firebasa
        getData()

        return view;
    }

    private fun getData(){
        val market="Tuš"
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    for(snap in snapshot.children){
                        if(snap.key=="name" && snap.value==market){
                            //to-do
                        }
                    }
                }
                Log.w(TAG, "loadPost:Sucess")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        reference.addValueEventListener(postListener)
    }
}