package com.pakt_games.layoutandfragmentexample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_word_test.*


class WordTest : Fragment() {

    //Definition
    val sendIngWord="Respect"
    val sendTrWordArray=arrayOf<String>("Saygı","Güven","Başarı","Temel")
    val questionAnswerFragment=QuestionAnswer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_start.setOnClickListener {
            btnStartEvent(it)
        }
    }

    fun btnStartEvent(view: View)
    {
        //Data Migration to Fragment
        val bundle=Bundle()
        bundle.putString("ingWord",sendIngWord)
        bundle.putStringArray("trWordArray",sendTrWordArray)
        questionAnswerFragment.arguments=bundle
        //Checked Activity
        activity?.let {
            //Fragment Transaction
            val fragmentManager=it!!.supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout,questionAnswerFragment).commit()
        }
    }
}