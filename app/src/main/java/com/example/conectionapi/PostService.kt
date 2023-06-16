package com.example.conectionapi

import retrofit2.Call
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/posts

interface PostService {

    @GET("posts")
    fun list(): Call<List<PostEntity>>
}