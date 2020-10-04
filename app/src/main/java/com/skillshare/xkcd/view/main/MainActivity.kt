package com.skillshare.xkcd.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.skillshare.xkcd.R
import com.skillshare.xkcd.view.main.MainPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentPager = findViewById<ViewPager>(R.id.main_fragment_pager)
        val fragmentPagerAdapter =
            MainPagerAdapter(
                supportFragmentManager,
                resources
            )
        fragmentPager.adapter = fragmentPagerAdapter
    }
}
