package com.melayer.hndchngs

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this@MainActivity, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this@MainActivity, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        Toast.makeText(this@MainActivity, "onConfigurationChanged", Toast.LENGTH_SHORT).show()

        when {
            newConfig?.orientation == Configuration.ORIENTATION_LANDSCAPE -> {
                imgVw.setImageResource(R.drawable.ic_backup_black_24dp)
            }
            newConfig?.orientation == Configuration.ORIENTATION_PORTRAIT -> {
                imgVw.setImageResource(R.drawable.ic_cloud_black_24dp)
            }
            else -> {
                imgVw.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this@MainActivity, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}
