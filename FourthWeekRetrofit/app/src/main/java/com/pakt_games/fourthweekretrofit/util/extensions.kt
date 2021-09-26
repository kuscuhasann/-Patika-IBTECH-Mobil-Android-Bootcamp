package com.pakt_games.fourthweekretrofit.util

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun EditText.getTextAndChangeToString(): String {
    return this.text.toString()
}

fun Fragment.toast(messageToShow: Int, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(requireContext(), messageToShow, duration).show()
}
fun AppCompatActivity.toast(messageToShow: Int, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, messageToShow, duration).show()
}
fun Fragment.saveToken(key: String, value: String) {
    val sharedPreferences: SharedPreferences =
        requireActivity().getSharedPreferences("Token", Context.MODE_PRIVATE)
    val tokenEdit = sharedPreferences.edit()
    tokenEdit.putString(key, value)
    tokenEdit.apply()
}
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}