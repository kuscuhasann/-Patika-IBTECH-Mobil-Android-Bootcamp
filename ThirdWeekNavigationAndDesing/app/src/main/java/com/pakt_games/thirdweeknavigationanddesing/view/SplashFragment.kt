package com.pakt_games.thirdweeknavigationanddesing.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pakt_games.thirdweeknavigationanddesing.R
import com.pakt_games.thirdweeknavigationanddesing.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash.*
import java.util.*


class SplashFragment : Fragment() {

    //Defination
    private val DELAY: Long = 3 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFragmet()
    }

    private fun getFragmet() {
        //delay 3 second
        Handler(Looper.getMainLooper()).postDelayed({
            //Invisble progressbar
            progressBarSplashFragmentLoading.visibility=View.INVISIBLE
            //geting fragment
            findNavController().navigate(R.id.action_splashFragment_to_battleFragment)

        }, DELAY)
    }


}