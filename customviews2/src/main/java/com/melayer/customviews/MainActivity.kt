package com.melayer.customviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
                //MyView(context = this@MainActivity, attr = null)
                R.layout.activity_main
        )
    }
}
