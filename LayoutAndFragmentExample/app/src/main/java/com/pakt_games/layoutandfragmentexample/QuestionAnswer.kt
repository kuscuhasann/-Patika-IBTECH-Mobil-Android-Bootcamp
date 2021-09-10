package com.pakt_games.layoutandfragmentexample

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pakt_games.layoutandfragmentexample.utilities.replaceFragmentSafely
import kotlinx.android.synthetic.main.fragment_question_answer.*


class QuestionAnswer : Fragment() {

    //Definition
    var getIngWord:String?=""
    var getTrWordArray:Array<String>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_answer, container, false)


    }
    //Fragment if created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Pulling the data in Fragment
        getIngWord=arguments?.getString("ingWord")
        getTrWordArray=arguments?.getStringArray("trWordArray")
        main_word.setText(getIngWord)
        btnA.setText(getTrWordArray?.get(0))
        btnB.setText(getTrWordArray?.get(1))
        btnC.setText(getTrWordArray?.get(2))
        btnD.setText(getTrWordArray?.get(3))
        //Starting timer for timer object
        startTimer()
    }

     fun startTimer()
    {

        val timer = object: CountDownTimer(20000, 1000) {
            //If timer is working
            override fun onTick(millisUntilFinished: Long) {
                timer_object.text=(millisUntilFinished/1000).toString()
                //ProgressBar data reduction
                progress_circular_object.progress-=5;
            }
            //If timer is finished
            override fun onFinish() {
               timer_object.text="0";
            }
        }
        timer.start()
    }


}