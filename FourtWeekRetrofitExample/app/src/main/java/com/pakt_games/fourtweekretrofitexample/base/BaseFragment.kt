package com.pakt_games.fourtweekretrofitexample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment(),IBaseFragment{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    abstract fun getLayoutID() : Int

    override fun showPopUp() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireContext())
                    .setTitle("Bilgi")
                    .setMessage("Uygulamadan çıkmak ister misiniz?")
                    .setCancelable(false)
                    .setPositiveButton("Evet"
                    ) { _, _ -> activity?.finish() }
                    .setNegativeButton("Hayır", null)
                    .show()
            }
        })
    }
    open fun prepareView(){}
}