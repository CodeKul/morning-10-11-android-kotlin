package com.melayer.intinfltr

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener {
           anything()
        }
    }

    fun concept() {
        val intent = Intent()
        intent.action = "com.codekul.action.NEWS"
        intent.data = Uri.parse("http://codekul.com")
//            intent.addCategory("com.codekul.category.CRICKET")
        startActivity(intent)
    }

    private fun dial() = startActivity(Intent(Intent.ACTION_DIAL))

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel://9762548833")
        startActivity(intent)
    }

    private fun anything() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("http://codekul.com")
        startActivity(intent)
    }
}
