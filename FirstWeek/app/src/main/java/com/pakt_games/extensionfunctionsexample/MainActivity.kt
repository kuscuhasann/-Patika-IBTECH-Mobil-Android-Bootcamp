package com.pakt_games.extensionfunctionsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pakt_games.extensionfunctionsexample.utility.reverseAfterSelectedIndex

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myArray= arrayOf(3,2,7,4,1)

        //Using Extension Function
        //myArray.cevir() ->non parameters
        myArray.reverseAfterSelectedIndex(2)

        //Foreach
        for ((index, value) in myArray.withIndex()) {
            println("The element at $index is $value")
        }
    }
}