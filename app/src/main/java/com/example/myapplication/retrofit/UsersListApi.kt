package com.example.myapplication.retrofit

import com.example.myapplication.entity.ResponseUsersModel
import retrofit2.Response
import retrofit2.http.GET

interface UsersListApi {
    @GET("users")
   suspend fun getUsers():Response<List<ResponseUsersModel>>
}