package com.melayer.basicui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cntx: Context = this@MainActivity

        val clk : View.OnClickListener  = object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        }
        btnOkay.setOnClickListener(clk)

        val clkV2: View.OnClickListener = View.OnClickListener {

        }

        btnOkay.setOnClickListener(clkV2)

        btnOkay.setOnClickListener(this::clicked)

        btnOkay.setOnClickListener {
            val mb = etMb.text.toString()
            val pass = etPass.text.toString()
            if (mb == pass) txtRs.text = "Success"
            else txtRs.text = "Fail"
        }

        val vw: View = btnOkay

        val lyt : LinearLayout = LinearLayout(this@MainActivity)

        val cnst : ConstraintLayout = ConstraintLayout(this@MainActivity)
    }
    private fun clicked(vw : View) {

    }
}
