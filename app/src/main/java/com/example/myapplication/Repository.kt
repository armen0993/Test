package com.example.myapplication

import com.example.myapplication.entity.ResponsePostsModel
import com.example.myapplication.entity.ResponseUsersModel

interface Repository {

    suspend fun getListPosts():List<ResponsePostsModel>?
    suspend fun getListUsers():List<ResponseUsersModel>?

}