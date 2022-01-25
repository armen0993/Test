package com.example.myapplication.ui.users.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eddy.myapplication.R
import com.example.myapplication.entity.ResponseUsersModel
import com.example.myapplication.ui.users.viewHolder.UsersViewHolder

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class UsersAdapter(private val context: Context, private val listData: List<ResponseUsersModel>) :
    RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_users, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.email.text = listData[position].email
        holder.phone.text= listData[position].phone
        holder.userName.text = listData[position].username
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}