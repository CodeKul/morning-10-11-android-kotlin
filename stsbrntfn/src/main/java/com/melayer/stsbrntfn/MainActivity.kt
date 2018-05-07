package com.melayer.stsbrntfn

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener {
            shNtfn()
        }
    }

    fun shNtfn() {
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val ntfn = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification
                    .Builder(this, "4545")
                    .setTicker("This is sample")
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .build()
        }else {
            Notification
                    .Builder(this)
                    .setTicker("This is sample")
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(
                            PendingIntent.getActivity(
                                    MainActivity@this,
                                    8965,
                                    Intent(MainActivity@this, NtfnActivity::class.java),
                                    PendingIntent.FLAG_UPDATE_CURRENT
                            )
                    )
                    .setDefaults(Notification.DEFAULT_ALL)
                    .build()
        }
        mgr.notify(7894,ntfn)
    }
}
