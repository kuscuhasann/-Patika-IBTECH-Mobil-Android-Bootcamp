package com.pakt_games.fourthweekretrofit.view

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.pakt_games.fourthweekretrofit.R
import com.pakt_games.fourthweekretrofit.base.BaseFragment
import com.pakt_games.fourthweekretrofit.model.User
import com.pakt_games.fourthweekretrofit.service.BaseCallBack
import com.pakt_games.fourthweekretrofit.service.LoginResponse
import com.pakt_games.fourthweekretrofit.service.ServiceConnector
import com.pakt_games.fourthweekretrofit.util.USER_TOKEN
import com.pakt_games.fourthweekretrofit.util.getTextAndChangeToString
import com.pakt_games.fourthweekretrofit.util.saveToken
import com.pakt_games.fourthweekretrofit.util.toast
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment() {


    override fun getLayoutID() = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
        val prefences = requireActivity().getSharedPreferences("Token", Context.MODE_PRIVATE)
        val token = prefences.getString(USER_TOKEN,"Token")
        if(token!=null){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
    override fun prepareView() {
        super.prepareView()
        buttonLogin.setOnClickListener {
            hitLoginEndpoint()

        }
    }
    private fun hitLoginEndpoint() {
        //Checked String Fields
        val email = editTextEmailAdress.getTextAndChangeToString()
        val password = editTextPassword.getTextAndChangeToString()

        if (allFieldsAreValid(email, password)) {
        val params = mutableMapOf<String, String>().apply {
            put("email", email)
            put("password", password)
        }
            //Connector
            ServiceConnector.restInterface.login(params)
                .enqueue(object : BaseCallBack<LoginResponse>() {
                override fun onSuccess(data: LoginResponse) {
                    super.onSuccess(data)
                    User.getCurrentInstance().token = data.token
                    saveToken(USER_TOKEN, data.token)
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                }
                override fun onFailure() {
                    super.onFailure()
                    toast(R.string.toast_fail)
                }
            })
        } else {
            toast(R.string.toast_check_fields)
        }
    }
    //Validate Fields
    private fun allFieldsAreValid(
        email: String,
        password: String
    ): Boolean {
        var allFieldsAreValid = true
        if (email.isEmpty() || !isValidEmail(email)) allFieldsAreValid = false
        if (password.isEmpty() || password.length < 7) allFieldsAreValid = false

        return allFieldsAreValid
    }
    //Email Check
    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}