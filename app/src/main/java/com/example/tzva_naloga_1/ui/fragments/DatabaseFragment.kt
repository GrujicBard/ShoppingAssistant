package com.example.tzva_naloga_1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tzva_naloga_1.R
import com.example.tzva_naloga_1.adapters.RecyclerViewAdapter
import com.example.tzva_naloga_1.database.UserViewModel
import com.example.tzva_naloga_1.database.entities.UserEntity
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL

class DatabaseFragment : Fragment(), RecyclerViewAdapter.RowClickListener  {

    lateinit var viewModel: UserViewModel;
    lateinit var recyclerViewAdapter: RecyclerViewAdapter;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_database, container, false);

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview);

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext());
            recyclerViewAdapter = RecyclerViewAdapter(this@DatabaseFragment);
            adapter = recyclerViewAdapter;
        }

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.getAllUsersObservers().observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })

        return view;
    }

    fun recycviewAdapaterIsInit(): Boolean {
        if(::recyclerViewAdapter.isInitialized) {
            return true;
        }
        return false;
    }

    override fun onDeleteUserClickListener(user: UserEntity) {
        viewModel.deleteUser(user)
    }

    override fun onItemClickListener(user: UserEntity) {
        TODO("Not yet implemented")
    }

}