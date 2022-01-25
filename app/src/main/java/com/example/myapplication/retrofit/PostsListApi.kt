package com.example.myapplication.retrofit

import com.example.myapplication.entity.ResponsePostsModel
import com.example.myapplication.entity.ResponseUsersModel
import retrofit2.Response
import retrofit2.http.GET

interface PostsListApi {

    @GET("posts")
   suspend fun getList() : Response<List<ResponsePostsModel>>


}