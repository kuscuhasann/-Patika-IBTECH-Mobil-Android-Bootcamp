package com.pakt_games.fourtweekretrofitexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.pakt_games.fourtweekretrofitexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.app_graph)

        val state = intent.getStringExtra("state")

        if (state.equals("home")) graph.startDestination = R.id.homeFragment
        else graph.startDestination = R.id.loginFragment

        navHostFragment.navController.graph = graph
    }
}