package com.pakt_games.fourtweekretrofitexample.service

import com.google.gson.annotations.SerializedName
import com.pakt_games.fourtweekretrofitexample.model.User

data class LoginResponse(
    @SerializedName("user") val user: User,
    val token: String
)