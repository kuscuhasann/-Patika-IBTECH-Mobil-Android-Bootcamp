package com.pakt_games.fourtweekretrofitexample.base

import androidx.annotation.IdRes

interface BaseRecyclerViewItemClickListener<T> {
    fun onItemClicked(clickedObject: T, @IdRes id: Int = 0)
}