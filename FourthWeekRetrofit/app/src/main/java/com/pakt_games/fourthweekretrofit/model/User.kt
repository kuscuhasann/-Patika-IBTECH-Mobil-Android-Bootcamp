package com.pakt_games.fourthweekretrofit.model

import com.google.gson.annotations.SerializedName

class User(

) {
    @SerializedName("name")
    var userName: String?= null
    var email : String ?= null
    var age: Int? = null
    var token : String? = null

    companion object{
        var user : User? = null

        fun getCurrentInstance() : User {
            if(user == null){
                user = User()
            }
            return user!!
        }
    }
    fun setUser(registeredUser: User){
        user?.userName = registeredUser.userName
        user?.email = registeredUser.email
        user?.age = registeredUser.age
        user?.token = token
    }
}