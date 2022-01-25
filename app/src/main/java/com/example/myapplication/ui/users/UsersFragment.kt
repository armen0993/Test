package com.example.myapplication.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eddy.myapplication.databinding.FragmentUsersBinding
import com.example.myapplication.entity.ResponseUsersModel
import com.example.myapplication.ui.users.adapter.UsersAdapter
import com.example.myapplication.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class UsersFragment : Fragment() {

    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTitle()
        getListUsers()
    }

    private fun getTitle() {
        viewModel.getTitleLiveData.observe(viewLifecycleOwner, {
            binding.title.text = it.toString()
        })
    }

    private fun getListUsers() {
        viewModel.getListUsers()
        viewModel.listUsersLiveData.observe(viewLifecycleOwner, {
            initRecycler(it)
        })
    }

    private fun initRecycler(listUsers: List<ResponseUsersModel>) {
        val recyclerUsers = binding.recyclerUsers
        recyclerUsers.adapter = UsersAdapter(requireContext(), listUsers)
        recyclerUsers.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

    }

}