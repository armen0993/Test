package com.eddy.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddy.myapplication.Repository
import com.eddy.myapplication.entity.ResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class MainViewModel(val repository: Repository) : ViewModel() {

    private val _listPostsLiveData: MutableLiveData<List<ResponseData>> = MutableLiveData()

    val listPostsLiveData: LiveData<List<ResponseData>> = _listPostsLiveData

    fun getListPosts(list:MutableList<ResponseData>) {
        viewModelScope.launch(Dispatchers.IO) {

            val response = repository.getListPosts()


            if (response != null) {
                for (i in response.indices) {

                list.add(i,ResponseData(response[i].title.toString(),response[i].body.toString()))


                }
            }

            _listPostsLiveData.postValue(list)

        }
    }
}