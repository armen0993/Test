package com.example.myapplication.ui.posts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.R
import com.example.myapplication.entity.ResponsePostsModel
import com.example.myapplication.ui.posts.viewHolder.PostsViewHolder
import com.example.myapplication.viewModel.MainViewModel

class PostsAdapter(private val context: Context, private val listData: List<ResponsePostsModel>,
                   private val viewModel: MainViewModel
) :
    RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_posts, parent, false)
        return PostsViewHolder(view, viewModel)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.title.text = listData[position].title
        holder.body.text = listData[position].body

        listData[position].title?.let { holder.click(it) }


    }

    override fun getItemCount(): Int {
        return listData.size
    }
}