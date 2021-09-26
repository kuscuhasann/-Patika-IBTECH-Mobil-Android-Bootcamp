package com.pakt_games.fourtweekretrofitexample.model

import com.google.gson.annotations.SerializedName

class Task {
    var completed: Boolean = false
    var isSwiped: Boolean = false
    var viewType: Int = 1

    //val viewType: Int
    @SerializedName
        ("_id")
    var id: String? = null
    var description: String? = null
    var owner: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
}