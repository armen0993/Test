package com.eddy.myapplication.ui.posts.viewHolder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.databinding.ItemPostsBinding
import com.eddy.myapplication.viewModel.MainViewModel

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class PostsViewHolder(itemView: View, private val viewModel: MainViewModel) :
    RecyclerView.ViewHolder(itemView) {


    private val binding = ItemPostsBinding.bind(itemView.rootView)

    var title = binding.title
    var body = binding.body

    fun click(title: String) {
        binding.containerPosts.setOnClickListener {
            viewModel.getClick(true)
            Log.d("lager","clicked in holder")
        }


    }

}