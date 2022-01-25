package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository
import com.example.myapplication.entity.ResponsePostsModel
import com.example.myapplication.entity.ResponseUsersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {

    private val _listUsersLiveData:MutableLiveData<List<ResponseUsersModel>> = MutableLiveData()
    val listUsersLiveData: LiveData<List<ResponseUsersModel>> = _listUsersLiveData

    fun getListUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getListUsers()
            _listUsersLiveData.postValue(response)
        }

    }

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


    private val _getTitleLiveData:MutableLiveData<String> = MutableLiveData()
    val getTitleLiveData:LiveData<String> = _getTitleLiveData

    fun getTitle(title:String){
        _getTitleLiveData.postValue(title)
    }


}