package com.example.kotlincoroutines.network

import com.example.kotlincoroutines.model.PostData
import com.example.kotlincoroutines.model.User
import retrofit2.http.GET

interface ApiServices {

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("posts")
    suspend fun getPosts(): List<PostData>
}