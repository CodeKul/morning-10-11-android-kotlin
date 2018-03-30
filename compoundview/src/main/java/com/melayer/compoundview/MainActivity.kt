package com.melayer.compoundview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener(this::clicked)
    }

    private fun clicked(view : View) {
        val vw : View = layoutInflater.inflate(
                R.layout.layout_compound,
                null,
                false
        )
        vw.findViewById<ImageView>(R.id.imgVw).setOnClickListener {
            (it as ImageView).setImageResource(R.mipmap.ic_launcher_round)
        }
        vw.findViewById<TextView>(R.id.txtVw).setOnClickListener {
            (it as TextView).textSize = 50f
        }

        layoutRoot.addView(vw)
    }
}
