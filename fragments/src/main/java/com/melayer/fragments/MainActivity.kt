package com.melayer.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFrag(ScreenFragment())
    }

    fun loadFrag(frag : Fragment) =
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, frag)
                    .commit()
}
