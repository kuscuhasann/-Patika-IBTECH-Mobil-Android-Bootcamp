package com.pakt_games.fourtweekretrofitexample

import android.app.Application
import com.pakt_games.fourtweekretrofitexample.service.ServiceConnector

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        ServiceConnector.init()
    }
}