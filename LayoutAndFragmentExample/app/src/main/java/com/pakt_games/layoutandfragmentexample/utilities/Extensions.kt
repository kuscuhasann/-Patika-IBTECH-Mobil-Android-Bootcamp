package com.pakt_games.layoutandfragmentexample.utilities


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.pakt_games.layoutandfragmentexample.MainActivity
import com.pakt_games.layoutandfragmentexample.WordTest
//called startActivity
inline fun<reified T : AppCompatActivity> Context.startActivity(block : Intent.() -> Unit = {}){
        val intent  = Intent(this , T::class.java)
        startActivity(
                intent.also {
                        block.invoke(it)
                }
        )
}
//called fragment
 fun AppCompatActivity.replaceFragmentSafely(fragmentName: Fragment,@IdRes containerViewId: Int){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        //fragment class
        val questionAnswerFragment= fragmentName
        //replacing fragment
        fragmentTransaction.replace(containerViewId,questionAnswerFragment).commit()
}


