package com.pakt_games.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.pakt_games.myapplication.viewpager.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tabTitle = arrayOf("FİLMLER","FAVORİ FİLMLER")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2.adapter = MainViewPagerAdapter(supportFragmentManager , lifecycle)

        TabLayoutMediator(tabLayout,viewPager2) {
                tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}