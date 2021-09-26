package com.pakt_games.fourthweekretrofit.service

import com.pakt_games.fourthweekretrofit.model.User
import retrofit2.Call
import retrofit2.http.*

interface AppAPI {
    @GET("user/me")
    fun getMe(): Call<User>

    @POST("user/login")
    fun login(@Body params: MutableMap<String, String>): Call<LoginResponse>

}