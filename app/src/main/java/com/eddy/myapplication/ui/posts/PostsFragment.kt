package com.eddy.myapplication.ui.posts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.viewModel.MainViewModel
import com.eddy.myapplication.R
import com.eddy.myapplication.entity.ResponseData
import com.eddy.myapplication.ui.posts.adapter.PostsAdapter
import com.eddy.myapplication.ui.posts.viewHolder.PostsViewHolder
import org.koin.android.viewmodel.ext.android.viewModel


class PostsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private val list = mutableListOf<ResponseData>()

    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPostsList()

    }

    private fun getPostsList() {

        viewModel.getListPosts(list = list)
        viewModel.listPostsLiveData.observe(viewLifecycleOwner, {
            initRecycler(list)
        })
    }

    private fun initRecycler(listData: List<ResponseData>) {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler)
        recyclerView?.adapter = PostsAdapter(requireContext(), listData)
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

}