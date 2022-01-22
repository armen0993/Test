package com.eddy.myapplication.ui.posts.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.R
import com.eddy.myapplication.databinding.ItemPostsBinding

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class PostsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    private val binding = ItemPostsBinding.bind(itemView.rootView)

    var title = binding.title
    var body = binding.body

}