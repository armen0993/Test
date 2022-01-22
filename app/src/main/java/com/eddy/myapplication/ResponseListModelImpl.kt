package com.eddy.myapplication

import android.content.Context
import com.eddy.myapplication.entity.ResponsePostsModel
import com.eddy.myapplication.retrofit.PostsListApi
import com.eddy.myapplication.retrofit.RetrofitService

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class ResponseListModelImpl(val context: Context) : Repository {

    override suspend fun getListPosts(): List<ResponsePostsModel>? {


        val response = RetrofitService.retrofit.create(PostsListApi::class.java).getList()


        if (response.isSuccessful && response.body() != null) {

            return response.body()
        }
        return null
    }


}