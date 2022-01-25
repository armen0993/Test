package com.example.myapplication.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.R
import com.example.myapplication.entity.ResponsePostsModel
import com.example.myapplication.ui.posts.adapter.PostsAdapter
import com.example.myapplication.ui.users.UsersFragment
import com.example.myapplication.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class PostsFragment : Fragment() {

    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPostsList()
        checkerClick()

    }

    private fun checkerClick() {
        viewModel.clickCheckerLiveData.observe(viewLifecycleOwner, {
            if (it) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, UsersFragment())
                    .addToBackStack("Back")
                    .commit()
            }
        })
    }

    private fun getPostsList() {

        viewModel.getListPosts()
        viewModel.listPostsLiveData.observe(viewLifecycleOwner, {
            initRecycler(it)
        })
    }

    private fun initRecycler(listData: List<ResponsePostsModel>) {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler)
        recyclerView?.adapter = PostsAdapter(requireContext(), listData, viewModel)
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

}