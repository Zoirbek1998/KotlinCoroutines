package com.example.kotlincoroutines.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostData(
    @SerialName("body")
    val body: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("userId")
    val userId: Int? = null
)