package com.pakt_games.fourtweekretrofitexample.service

import com.pakt_games.fourtweekretrofitexample.model.Task


data class TaskResponse(
    val data: MutableList<Task>,
    val count: Int
)
