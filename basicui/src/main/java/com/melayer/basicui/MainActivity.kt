package com.melayer.basicui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener {
            val mb = etMb.text.toString()
            val pass = etPass.text.toString()
            if(mb == pass)  txtRs.text = "Success"
            else txtRs.text = "Fail"
        }

    }
}
