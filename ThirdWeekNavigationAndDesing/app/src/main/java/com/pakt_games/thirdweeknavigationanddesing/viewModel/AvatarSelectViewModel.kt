package com.pakt_games.thirdweeknavigationanddesing.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakt_games.thirdweeknavigationanddesing.R
import com.pakt_games.thirdweeknavigationanddesing.model.Data
import com.pakt_games.thirdweeknavigationanddesing.util.imageView
import com.pakt_games.thirdweeknavigationanddesing.util.stringView

class AvatarSelectViewModel: ViewModel() {
    //Defination
    val dataset= MutableLiveData<List<Data>>()

    fun getData()
    {
        //fake data
        val string=Data(stringView, R.string.data_text_for_recycler,null)
        val user_1=Data(imageView, null,R.drawable.ic_avatar01)
        val user_2=Data(imageView, null,R.drawable.ic_avatar02)
        val user_3=Data(imageView, null,R.drawable.ic_avatar03)
        val user_4=Data(imageView, null,R.drawable.ic_avatar04)
        val user_5=Data(imageView, null,R.drawable.ic_avatar05)
        val user_6=Data(imageView, null,R.drawable.ic_avatar06)
        val user_7=Data(imageView, null,R.drawable.ic_avatar07)
        val user_8=Data(imageView, null,R.drawable.ic_avatar08)
        val user_9=Data(imageView, null,R.drawable.ic_avatar09)
        val user_10=Data(imageView, null,R.drawable.ic_avatar01)
        val user_11=Data(imageView, null,R.drawable.ic_avatar02)
        val user_12=Data(imageView, null,R.drawable.ic_avatar03)
        val user_13=Data(imageView, null,R.drawable.ic_avatar07)
        val user_14=Data(imageView, null,R.drawable.ic_avatar03)
        val user_15=Data(imageView, null,R.drawable.ic_avatar01)
        val user_16=Data(imageView, null,R.drawable.ic_avatar09)

        //add item to the data list
        val dataList= arrayListOf(string,user_1,user_2,user_3,user_4,user_5,user_6,user_7,user_8,user_9,user_10,user_11,user_12,user_13,user_14,user_15,user_16)
        //Binding Mutable data
        dataset.value=dataList
    }
}