package com.example.myapplication.ui.posts.viewHolder


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.databinding.ItemPostsBinding
import com.example.myapplication.viewModel.MainViewModel

class PostsViewHolder(itemView: View, private val viewModel: MainViewModel) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ItemPostsBinding.bind(itemView.rootView)

    var title = binding.title
    var body = binding.body

    fun click(title: String) {
        binding.containerPosts.setOnClickListener {
            viewModel.getClick(true)
            viewModel.getTitle(title)
        }
    }
}