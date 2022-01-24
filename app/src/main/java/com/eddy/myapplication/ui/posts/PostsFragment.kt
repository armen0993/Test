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
import com.eddy.myapplication.entity.ResponsePostsModel
import com.eddy.myapplication.ui.posts.adapter.PostsAdapter
import com.eddy.myapplication.ui.users.UsersFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class PostsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

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

    private fun checkerClick(){
        viewModel.clickCheckerLiveData.observe(viewLifecycleOwner,{
            Log.d("lager","clicked in fragment $it")
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.container,UsersFragment())

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
        recyclerView?.adapter = PostsAdapter(requireContext(), listData,viewModel)
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    }

}