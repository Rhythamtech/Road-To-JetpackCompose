package com.rhytham.ktorclient.Network

import com.rhytham.ktorclient.Model.Post
import com.rhytham.ktorclient.Network.ApiClient.client
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

class ApiRepository {

    suspend fun getAllPosts(): List<Post> = client.get(ApiRoutes.BLOG_POST).body()

    suspend fun createNewPost(newPost: Post): Post =  client.post(ApiRoutes.BLOG_POST){
        setBody(newPost)
    }.body()

    suspend fun updatePost(id:Int, post: Post):Post = client.put(ApiRoutes.BLOG_POST+"/$id"){
        setBody(post)
    }.body()

    suspend fun deletePost(id:Int) = client.delete("${ApiRoutes.BLOG_POST}/$id")
}
