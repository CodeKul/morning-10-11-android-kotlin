package com.melayer.dlgntfn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlert.setOnClickListener {
            showDialog("alert")
        }

        btnDate.setOnClickListener {
            showDialog("date")
        }

        btnTime.setOnClickListener {
            showDialog("time")
        }

        btnProg.setOnClickListener {
            showDialog("progress")
        }

        btnCust.setOnClickListener {

        }
    }

    private fun showDialog(tag : String) = BlankFragment().show(
            supportFragmentManager,
            tag
    )
}
