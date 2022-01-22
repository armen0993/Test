package com.eddy.myapplication

import com.eddy.myapplication.entity.ResponsePostsModel

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
interface Repository {

    suspend fun getListPosts():List<ResponsePostsModel>?

}