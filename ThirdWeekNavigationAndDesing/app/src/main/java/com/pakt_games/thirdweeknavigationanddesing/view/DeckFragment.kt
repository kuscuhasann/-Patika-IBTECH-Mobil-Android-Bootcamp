package com.pakt_games.thirdweeknavigationanddesing.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pakt_games.thirdweeknavigationanddesing.R
import com.pakt_games.thirdweeknavigationanddesing.base.BaseFragment


class DeckFragment : BaseFragment() {

    override fun getLayoutID(): Int = R.layout.fragment_deck

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //checking pop up
        exitShowPopUp()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deck, container, false)
    }


}