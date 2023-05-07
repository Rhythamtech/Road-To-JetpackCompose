package com.rhytham.ktorclient.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post (
    @SerialName( value = "id")
    val id:Int,

    @SerialName( value = "title")
    val title:String,

    @SerialName( value = "body")
    val body: String,

    @SerialName( value = "userId")
    val userId:String
)