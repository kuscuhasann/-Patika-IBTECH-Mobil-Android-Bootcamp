package com.pakt_games.fourthweekretrofit.service

interface BaseResponseHandlerInterface<T> {
    fun onSuccess(data :  T)
    fun onFailure()
}