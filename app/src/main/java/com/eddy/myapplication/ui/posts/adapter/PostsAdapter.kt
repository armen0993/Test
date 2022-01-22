package com.eddy.myapplication.ui.posts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.R
import com.eddy.myapplication.entity.ResponseData
import com.eddy.myapplication.ui.posts.viewHolder.PostsViewHolder

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class PostsAdapter(private val context: Context, private val listData: List<ResponseData>) :
    RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_posts, parent, false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.title.text = listData[position].title
        holder.body.text = listData[position].body



    }

    override fun getItemCount(): Int {
        return listData.size
    }
}