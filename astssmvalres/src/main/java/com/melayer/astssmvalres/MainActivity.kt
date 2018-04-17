package com.melayer.astssmvalres

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mp3Ip = assets.open("my.mp3")
        val dr = R.drawable.abc_ab_share_pack_mtrl_alpha

        val wd = resources.getDimension(R.dimen.btnWd)
        val ttl = resources.getString(R.string.btnGo)
    }
}
