package com.example.tzva_naloga_1.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.database.ItemViewModel
import com.example.tzva_naloga_1.database.ItemViewModelFactory
import com.example.tzva_naloga_1.database.ItemsApplication
import com.example.tzva_naloga_1.database.entities.ItemCategory
import com.example.tzva_naloga_1.database.entities.ItemEntity
import com.example.tzva_naloga_1.database.entities.Shop
import com.example.tzva_naloga_1.database.entities.Storage
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.database.*
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException


@Suppress("DEPRECATION")
class InputFragment : Fragment() {
    private lateinit var database: DatabaseReference
    var market=""
    lateinit var productsArray:JSONArray

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
        ): View? {

        val view : View = inflater.inflate(R.layout.fragment_input, container, false)
//        val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
//        val picker : MaterialDatePicker<*> = builder.build()

        //Item
        val et_EAN: EditText = view.findViewById(R.id.et_EAN)
        val et_item_name: EditText = view.findViewById(R.id.et_item_name)
        val et_description: EditText = view.findViewById(R.id.et_description)
        val et_price: EditText = view.findViewById(R.id.et_price)
        val et_stock: EditText = view.findViewById(R.id.et_stock)
        val et_quantity: EditText = view.findViewById(R.id.et_quantity)
//        val cb_isFavoriteItem: CheckBox = view.findViewById(R.id.cb_isFavoriteItem)
//        val cb_isOnShoppingList: CheckBox = view.findViewById(R.id.cb_isOnShoppingList)
        val dd_storage: AutoCompleteTextView = view.findViewById(R.id.dd_storage)
        val dd_shop: AutoCompleteTextView = view.findViewById(R.id.dd_shop)
        val dd_cat: AutoCompleteTextView = view.findViewById(R.id.dd_cat)


        val success: String = getString(R.string.successfulCreation)
        val unSuccess: String = getString(R.string.unSuccessfulCreation)

        val btn_save : Button = view.findViewById(R.id.btn_save)
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        dd_cat.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, ItemCategory.values()))
        dd_storage.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, Storage.values()))
        dd_shop.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, Shop.values()))

        //Working datepicker
/*        builder.setTitleText(resources.getString(R.string.calendar))
        et_expirationDate.setOnClickListener{
            picker.show(parentFragmentManager, picker.toString())
            imm.hideSoftInputFromWindow(et_expirationDate.windowToken, 0)
        }

        et_expirationDate.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                picker.show(parentFragmentManager, picker.toString())
                imm.hideSoftInputFromWindow(et_expirationDate.windowToken, 0)
            } else {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                    InputMethodManager.HIDE_IMPLICIT_ONLY)
            }
        }

        picker.addOnPositiveButtonClickListener {
            et_expirationDate.setText(picker.headerText)
            cb_isFavoriteItem.requestFocus()
        }*/

        btn_save.setOnClickListener{
            val item = ItemEntity(
                0,
                et_EAN.text.toString(),
                et_item_name.text.toString(),
                et_price.text.toString().toDouble(),
                et_quantity.text.toString(),
                et_stock.text.toString().toInt(),
                dd_shop.text.toString(),
                dd_storage.text.toString(),
                dd_cat.text.toString(),
                description = et_description.text.toString()
            )

            if (et_EAN.text != null &&
                et_item_name.text != null &&
                et_description.text != null &&
                et_price.text != null &&
                et_quantity.text != null)
            {
                itemViewModel.insertItem(item)
                val toast = Toast.makeText(activity?.application, success, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM,0, 300);
                toast.show()
            }
        }
        market="Tuš"
        getDataFromFirebase()
        return view;
    }

    private fun getDataFromFirebase(){
        var database = FirebaseDatabase.getInstance()
        val reference = database.getReference("")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val gson = Gson()
                val data = gson.toJson(dataSnapshot.value)
                var arrayjson: JSONArray? = null
                try {
                    arrayjson = JSONArray(data)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                val jsonArray = arrayjson
                fetchProductFromMarket(jsonArray)
            }
            override fun onCancelled(databaseError: DatabaseError) {
                print(databaseError.message)
            }
        })
    }

    private fun fetchProductFromMarket(jsonArray: JSONArray?){
        if (jsonArray != null) {
            for (i in 0 until jsonArray.length()) {
                val element = jsonArray.getJSONObject(i)
                if(element.get("name").equals(market)){
                    var products=element.get("products")
                    val gson = Gson()
                    val json = gson.toJson(products)

                }
            }
        }
    }
}