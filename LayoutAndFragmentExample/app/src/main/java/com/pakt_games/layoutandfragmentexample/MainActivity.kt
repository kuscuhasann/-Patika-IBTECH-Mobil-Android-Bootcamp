package com.pakt_games.layoutandfragmentexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import com.pakt_games.layoutandfragmentexample.utilities.replaceFragmentSafely

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragmentSafely(WordTest(),R.id.frameLayout)


    }

    fun pushWordTestFragment(view: View)
    {

    }
    fun pushQuestionAnswerFragment(view: View)
    {

    }

}