package com.melayer.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        txtInf.text = savedInstanceState?.getString("dtTm")

        btnOkay.setOnClickListener {
            txtInf.text = System.currentTimeMillis().toString()
        }
        mt("onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("dtTm", txtInf.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        txtInf.text = savedInstanceState?.getString("dtTm")
    }

    override fun onStart() {
        super.onStart()
        mt("onStart")
    }

    override fun onResume() {
        super.onResume()
        mt("onResume")
    }

    override fun onPause() {
        mt("onPause")
        super.onPause()
    }

    override fun onRestart() {
        super.onRestart()
        mt("onRestart")
    }

    override fun onStop() {
        super.onStop()
        mt("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        mt("onDestroy")
    }

    private fun mt(msg : String) = Toast
            .makeText(this@MainActivity, msg, Toast.LENGTH_SHORT)
            .show()
}
