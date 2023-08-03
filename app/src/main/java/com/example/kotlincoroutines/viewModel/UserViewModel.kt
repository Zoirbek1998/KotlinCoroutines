package com.example.kotlincoroutines.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.model.UserWithPost
import com.example.kotlincoroutines.network.ApiClient
import com.example.kotlincoroutines.network.ApiServices
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val apiService = ApiClient.getRetrofit().create(ApiServices::class.java)
    private val liveData = MutableLiveData<UserWithPost>()

    init {
        fetchUsers()
    }

    

    // try-catch ning orniga bu ishlatilishi mumkin lekin ikkalasi birhil vazifa bajaradi
//    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//        print(exception)
//    }

    private fun fetchUsers() {
        //        (exceptionHandler)
        viewModelScope.launch {
            try {
                coroutineScope {
                    val async1 = async { apiService.getUsers() }
                    val async2 = async { apiService.getPosts() }
                    val userList = async1.await()
                    val postList = async2.await()
                    liveData.postValue(UserWithPost(userList, postList))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getUserLiveData(): LiveData<UserWithPost> {
        return liveData
    }
}

