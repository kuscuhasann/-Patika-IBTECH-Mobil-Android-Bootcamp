package com.pakt_games.fourthweekretrofit

import android.app.Application
import com.pakt_games.fourthweekretrofit.service.ServiceConnector

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()
    }
}