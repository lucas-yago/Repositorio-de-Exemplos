package com.lucasyago.aprendendoretrofit.services

import com.lucasyago.aprendendoretrofit.entities.PostEntity
import retrofit2.Call
import retrofit2.http.GET

//  link -> https://jsonplaceholder.typicode.com/posts
//  link -> https://jsonplaceholder.typicode.com/users
//  link -> https://jsonplaceholder.typicode.com/albums

interface PostServices {

    @GET("posts")
    fun list(): Call<List<PostEntity>>


}