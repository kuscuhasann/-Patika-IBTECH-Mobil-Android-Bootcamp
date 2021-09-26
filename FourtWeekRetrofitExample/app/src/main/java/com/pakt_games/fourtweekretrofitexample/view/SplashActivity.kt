package com.pakt_games.fourtweekretrofitexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.pakt_games.fourtweekretrofitexample.R
import com.pakt_games.fourtweekretrofitexample.model.User
import com.pakt_games.fourtweekretrofitexample.service.BaseCallBack
import com.pakt_games.fourtweekretrofitexample.service.ServiceConnector
import com.pakt_games.fourtweekretrofitexample.util.USER_TOKEN
import com.pakt_games.fourtweekretrofitexample.util.gone
import com.pakt_games.fourtweekretrofitexample.util.toast

class SplashActivity : AppCompatActivity() {
    private var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        if (isLoggedIn()) {
            User.getCurrentInstance().token = token

            ServiceConnector.restInterface.getMe().enqueue(object : BaseCallBack<User>() {
                override fun onSuccess(data: User) {
                    super.onSuccess(data)

                    progressBar.gone()
                    User.getCurrentInstance().setUser(data)

                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    intent.putExtra("state", "home")
                    startActivity(intent)
                    finish()
                }

                override fun onFailure() {
                    super.onFailure()

                    toast("Please authenticate.")
                }
            })
        } else {
            progressBar.gone()

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            intent.putExtra("state", "login")
            startActivity(intent)
            finish()
        }
    }

    private fun isLoggedIn(): Boolean {
        val token = getToken()
        return token.isNotEmpty()
    }

    private fun getToken(): String {
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        token = sh.getString(USER_TOKEN, "")!!

        return token!!
    }

    private fun changeStatusBarColor(id: Int) {
        this.window.statusBarColor = resources.getColor(id)
    }
}