package com.melayer.brdrcvr

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val br =  object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            Log.i("@codekul", "hello")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener {
            sendBroadcast(
                    Intent("com.codekul.my.ACTION")
            )
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(
                br,
                IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
    }

    override fun onStop() {
        unregisterReceiver(br)
        super.onStop()
    }
}
