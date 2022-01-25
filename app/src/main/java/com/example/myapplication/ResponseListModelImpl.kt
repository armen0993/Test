package com.example.myapplication

import android.content.Context
import com.example.myapplication.entity.ResponsePostsModel
import com.example.myapplication.entity.ResponseUsersModel
import com.example.myapplication.retrofit.PostsListApi
import com.example.myapplication.retrofit.RetrofitService
import com.example.myapplication.retrofit.UsersListApi

class ResponseListModelImpl(val context: Context) : Repository {

    override suspend fun getListPosts(): List<ResponsePostsModel>? {


        val responsePosts =
            RetrofitService(context).retrofit.create(PostsListApi::class.java).getList()


        if (responsePosts.isSuccessful && responsePosts.body() != null) {

            return responsePosts.body()
        }
        return null
    }


    override suspend fun getListUsers(): List<ResponseUsersModel>? {
        val responseUsers =
            RetrofitService(context).retrofit.create(UsersListApi::class.java).getUsers()

        if (responseUsers.isSuccessful && responseUsers.body() != null) {
            return responseUsers.body()
        }
        return null
    }


}