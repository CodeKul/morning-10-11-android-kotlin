package com.melayer.interactcomm

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)

            val bndl = Bundle()
            bndl.putFloat("defSz", etSz.text.toString().toFloat())

            intent.putExtras(bndl)

            //startActivity(intent)

            startActivityForResult(intent, 4568)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            4568 -> if (resultCode == Activity.RESULT_OK) {
                val bndl = data?.extras
                etSz.setText(bndl?.getInt("chSz", 10).toString())
            }
        }
    }
}
