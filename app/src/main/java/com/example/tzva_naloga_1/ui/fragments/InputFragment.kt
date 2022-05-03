package com.example.tzva_naloga_1.ui.fragments

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.RecyclerViewAdapter
import com.example.tzva_naloga_1.database.UserViewModel
import com.example.tzva_naloga_1.database.entities.UserEntity
import com.example.tzva_naloga_1.ui.dialog_fragments.SummaryDialogFragment
import com.google.android.material.datepicker.MaterialDatePicker





@Suppress("DEPRECATION")
class InputFragment : Fragment() {

    lateinit var viewModel: UserViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_input, container, false);
        val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker();
        val picker : MaterialDatePicker<*> = builder.build();
        val et_name: EditText = view.findViewById(R.id.et_name);
        val et_surname: EditText = view.findViewById(R.id.et_surname);
        val et_dateBirth: EditText = view.findViewById(R.id.et_dateBirth);
        val et_heartRate: EditText = view.findViewById(R.id.et_heartRate);
        val et_oxy: EditText = view.findViewById(R.id.et_oxy);
        val et_bodyTemp: EditText = view.findViewById(R.id.et_bodyTemp);
        val btn_save : Button = view.findViewById(R.id.btn_save);
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        val database_fragment = DatabaseFragment();

        builder.setTitleText(resources.getString(R.string.calendar));

        et_dateBirth.setOnClickListener{
            picker.show(parentFragmentManager, picker.toString());
            imm.hideSoftInputFromWindow(et_dateBirth.windowToken, 0);
        };

        et_dateBirth.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                picker.show(parentFragmentManager, picker.toString());
                imm.hideSoftInputFromWindow(et_dateBirth.windowToken, 0);
            } else {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                    InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        };

        picker.addOnPositiveButtonClickListener {
            et_dateBirth.setText(picker.headerText);
            et_heartRate.requestFocus();
        };

        btn_save.setOnClickListener{
            val dialog = SummaryDialogFragment();

            val user = UserEntity(
                0,
                et_name.text.toString(),
                et_surname.text.toString(),
                et_dateBirth.text.toString(),
                et_heartRate.text.toString().toInt(),
                et_oxy.text.toString().toInt(),
                et_bodyTemp.text.toString().toInt()
            );
            viewModel = ViewModelProvider(this)[UserViewModel::class.java]
            viewModel.insertUser(user);

            if(database_fragment.recycviewAdapaterIsInit()){ //Doesn't work to refresh recyclerview after creating user!
                database_fragment.recyclerViewAdapter.notifyDataSetChanged(); // FIX THIS
            }

            dialog.show(parentFragmentManager, "summaryDialog")
        };

        return view;
    }


}