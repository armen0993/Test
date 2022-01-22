package com.eddy.myapplication.retrofit

import com.eddy.myapplication.entity.ResponsePostsModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
interface PostsListApi {

    @GET("posts")
   suspend fun getList() : Response<List<ResponsePostsModel>>
}