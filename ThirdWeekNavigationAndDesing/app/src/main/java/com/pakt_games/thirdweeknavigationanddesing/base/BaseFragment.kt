package com.pakt_games.thirdweeknavigationanddesing.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.pakt_games.thirdweeknavigationanddesing.MainActivity
import com.pakt_games.thirdweeknavigationanddesing.R

abstract class BaseFragment:Fragment(),IBaseFragment {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onResume() {
        super.onResume()
        //NavigationBar visibility control
        val baseActivity = activity as MainActivity
        if(isNavigationbarVisible())
            baseActivity.showNavigation()
        else
            baseActivity.hideNavigation()
    }

    //If client pressing the backbutton , showing the popUp
    override fun exitShowPopUp() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val alert=AlertDialog.Builder(requireContext())
                alert.setTitle(R.string.alert_pop_up_message_title_text)
                alert.setMessage(R.string.alert_pop_up_message_text)
                alert.setCancelable(false)
                alert.setNegativeButton(R.string.alert_pop_up_negative_button_text){ dialog, which ->
                    activity?.finish()
                }
                alert.setPositiveButton(R.string.alert_pop_up_positive_button_text){dialog,which ->
                    dialog.cancel()
                }.show()
            }
        })
    }

    abstract fun getLayoutID() : Int

}