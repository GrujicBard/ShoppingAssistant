package com.example.tzva_naloga_1.ui.dialog_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.tzva_naloga_1.R

class SummaryDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView: View = inflater.inflate(R.layout.fragment_summary_dialog, container, false);

        var btn_cancel = rootView.findViewById<View>(R.id.btn_close);

        btn_cancel.setOnClickListener{
            dismiss();
        };

        return rootView;
    }
}