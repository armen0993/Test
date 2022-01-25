package com.example.myapplication.ui.users.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.databinding.ItemUsersBinding

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class UsersViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    private val binding = ItemUsersBinding.bind(itemView.rootView)

    val userName = binding.userName
    val email = binding.email
    val phone = binding.phone
}