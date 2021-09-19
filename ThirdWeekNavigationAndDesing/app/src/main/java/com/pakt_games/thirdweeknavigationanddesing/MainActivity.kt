package com.pakt_games.thirdweeknavigationanddesing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.pakt_games.thirdweeknavigationanddesing.util.gone
import com.pakt_games.thirdweeknavigationanddesing.util.visible
import com.pakt_games.thirdweeknavigationanddesing.view.SplashFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash.*

class MainActivity : AppCompatActivity() {
    //Defination
    private val DELAY: Long = 3 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setup BottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(containerBottomSelectionFragment, navController)
    }
    //Hide BottomNavigationView
    fun hideNavigation() {
        containerBottomSelectionFragment.postDelayed(
            {
                containerBottomSelectionFragment.gone()

            }, 0
        )
    }
    //Show BottomNavigationView
    fun showNavigation() {
        containerBottomSelectionFragment.postDelayed(
            {
                containerBottomSelectionFragment.visible()

            }, 0
        )
    }

}