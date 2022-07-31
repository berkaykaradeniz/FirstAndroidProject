package com.example.zihindenhesaplama.remote

import retrofit2.Call
import retrofit2.http.*

interface RestApi {

    //@Headers("Content-Type: application/json")
    @POST("newUser")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>

}
