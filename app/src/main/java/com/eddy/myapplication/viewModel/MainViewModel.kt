package com.eddy.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddy.myapplication.Repository
import com.eddy.myapplication.entity.ResponseData
import com.eddy.myapplication.entity.ResponsePostsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class MainViewModel(val repository: Repository) : ViewModel() {

    private val _listPostsLiveData: MutableLiveData<List<ResponsePostsModel>> = MutableLiveData()

    val listPostsLiveData: LiveData<List<ResponsePostsModel>> = _listPostsLiveData

    fun getListPosts() {
        viewModelScope.launch(Dispatchers.IO) {

            val response = repository.getListPosts()


            _listPostsLiveData.postValue(response)

        }
    }

    private val _clickCheckerLiveData:MutableLiveData<Boolean> = MutableLiveData()
    val clickCheckerLiveData:LiveData<Boolean> = _clickCheckerLiveData

    fun getClick(clicked:Boolean){
        _clickCheckerLiveData.postValue(clicked)
    }
}