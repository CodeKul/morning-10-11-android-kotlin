package com.melayer.interactcomm

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    private val onSkLsnr = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            txtVw.textSize = progress.toFloat()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val bndl  = intent.extras

        txtVw.textSize = bndl.getFloat("defSz", 30f)

        skBr.setOnSeekBarChangeListener(onSkLsnr)

        btBk.setOnClickListener {

            val bkInt = Intent()

            val bndl = Bundle()
            bndl.putInt("chSz", skBr.progress)
            bkInt.putExtras(bndl)

            setResult(Activity.RESULT_OK, bkInt)
            finish()
        }
    }
}
