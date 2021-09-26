package com.pakt_games.fourthweekretrofit.service

import com.google.gson.annotations.SerializedName
import com.pakt_games.fourthweekretrofit.model.User

data class LoginResponse(
    @SerializedName("user") val user: User,
    val token : String)

