package com.pakt_games.fourtweekretrofitexample.service

interface BaseResponseHandlerInterface<T> {
    fun onSuccess(data: T)
    fun onFailure()
}
