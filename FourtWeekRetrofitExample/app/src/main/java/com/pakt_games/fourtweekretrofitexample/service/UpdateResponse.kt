package com.pakt_games.fourtweekretrofitexample.service

import com.pakt_games.fourtweekretrofitexample.model.Task


data class UpdateResponse(
    val success: Boolean,
    val data: Task
)