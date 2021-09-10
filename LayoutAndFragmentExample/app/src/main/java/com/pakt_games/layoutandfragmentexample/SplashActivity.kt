package com.pakt_games.layoutandfragmentexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pakt_games.layoutandfragmentexample.utilities.startActivity
import java.util.*

class SplashActivity : AppCompatActivity() {

    //Waiting 3 sec. for Splash Activity
    private val DELAY: Long=3*1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Timer Thread
        Timer().schedule(object : TimerTask() {
            override fun run() {
                //Called MainActivity
                startActivity<MainActivity>()
                //destroyed splash activitiy
                finish()
            }
        }, DELAY)
    }
}