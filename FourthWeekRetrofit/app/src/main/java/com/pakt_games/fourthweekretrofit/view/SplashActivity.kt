package com.pakt_games.fourthweekretrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pakt_games.fourthweekretrofit.R
import com.pakt_games.fourthweekretrofit.model.User
import com.pakt_games.fourthweekretrofit.service.BaseCallBack
import com.pakt_games.fourthweekretrofit.service.ServiceConnector
import com.pakt_games.fourthweekretrofit.util.USER_TOKEN
import com.pakt_games.fourthweekretrofit.util.gone
import com.pakt_games.fourthweekretrofit.util.toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (isLoggedIn()) {
            User.getCurrentInstance().token = token
        //API Connector
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
                    toast(R.string.toast_login_please)
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
    //Is client logged now?
    private fun isLoggedIn(): Boolean {
        val token = getToken()
        return token.isNotEmpty()
    }
//getting Token
    private fun getToken(): String {
        val sh = getSharedPreferences("Token", MODE_PRIVATE)
        token = sh.getString(USER_TOKEN, "")!!
        return token!!
    }

}
