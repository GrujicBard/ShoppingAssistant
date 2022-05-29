package com.example.tzva_naloga_1.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
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
import com.google.firebase.database.*
import com.google.gson.Gson
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*


@Suppress("DEPRECATION")
class InputFragment : Fragment() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((activity?.application as ItemsApplication).repository)
    }

    private lateinit var database: DatabaseReference
    private var market = ""
    private var ean = ""

    lateinit var et_EAN: EditText
    lateinit var et_item_name: EditText
    lateinit var et_price: EditText
    lateinit var et_description: EditText
    lateinit var et_stock: EditText
    lateinit var et_quantity: EditText

    lateinit var dd_storage: AutoCompleteTextView
    lateinit var dd_shop: AutoCompleteTextView
    lateinit var dd_cat: AutoCompleteTextView

    lateinit var success: String
    lateinit var unSuccess: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_input, container, false)
//        val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
//        val picker : MaterialDatePicker<*> = builder.build()

        //Item
        et_EAN = view.findViewById(R.id.et_EAN)
        et_item_name = view.findViewById(R.id.et_item_name)
        et_description = view.findViewById(R.id.et_description)
        et_price = view.findViewById(R.id.et_price)
        et_stock = view.findViewById(R.id.et_stock)
        et_quantity = view.findViewById(R.id.et_quantity)
//        val cb_isFavoriteItem: CheckBox = view.findViewById(R.id.cb_isFavoriteItem)
//        val cb_isOnShoppingList: CheckBox = view.findViewById(R.id.cb_isOnShoppingList)
        dd_storage = view.findViewById(R.id.dd_storage)
        dd_shop = view.findViewById(R.id.dd_shop)
        dd_cat = view.findViewById(R.id.dd_cat)

        var btn_ean_scan: Button = view.findViewById(R.id.btn_ean_scan)


        success = getString(R.string.successfulCreation)
        unSuccess = getString(R.string.unSuccessfulCreation)


        val success: String = getString(R.string.successfulCreation)
        val unSuccess: String = getString(R.string.unSuccessfulCreation)

        val btn_save: Button = view.findViewById(R.id.btn_save)
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        dd_cat.setAdapter(ArrayAdapter(requireContext(),
            R.layout.dropdown_item,
            ItemCategory.values()))
        dd_storage.setAdapter(ArrayAdapter(requireContext(),
            R.layout.dropdown_item,
            Storage.values()))
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

        btn_ean_scan.setOnClickListener {
            val options = ScanOptions()
            options.setDesiredBarcodeFormats(ScanOptions.ONE_D_CODE_TYPES)
            options.setPrompt(resources.getString(R.string.barcode))
            options.setBeepEnabled(false)
            barcodeLauncher.launch(options);
        }

        btn_save.setOnClickListener {
            insertNewItem()
        }

        return view;
    }

    private fun insertNewItem() {
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
            et_quantity.text != null
        ) {
            itemViewModel.insertItem(item)
            val toast = Toast.makeText(activity?.application, success, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 300);
            toast.show()
        }
    }

    private fun getDataFromFirebase() {
        val database = FirebaseDatabase.getInstance()
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

    private fun fetchProductFromMarket(jsonArray: JSONArray?) {
        if (jsonArray != null) {
            for (i in 0 until jsonArray.length()) {
                val element = jsonArray.getJSONObject(i)
                if (element.get("name").equals(market)) {
                    val products = element.getJSONArray("products")

                    for (p in 0 until products.length()) {
                        val product = products.getJSONObject(p)
                        if (product.get("EAN").equals(ean)) {
                            et_item_name.setText(product.get("name").toString())
                            et_price.setText(product.get("price").toString())
                            et_quantity.setText(product.get("quantity").toString())
                            et_description.setText(product.get("description").toString())

                            //default values
                            et_stock.setText("1")
                            dd_storage.setText(Storage.FREEZER.toString(), false)

                            //Set these from database
                            dd_cat.setText(ItemCategory.MILK_EGGS_AND_DAIRY_PRODUCTS.toString(), false)
                            dd_shop.setText(Shop.SPAR.toString(), false)
                            break;
                        } else {
                            Toast.makeText(requireContext(), "Product not in database.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private val barcodeLauncher = registerForActivityResult(ScanContract()
    ) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            et_EAN.setText(result.contents.toString())
            market = "Tuš"
            ean = result.contents.toString()
            getDataFromFirebase()
        }
    }
}