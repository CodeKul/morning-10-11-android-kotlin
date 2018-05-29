package com.codekul.wifi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.net.wifi.WifiConfiguration

class MainActivity : AppCompatActivity() {

    val scnRcvr = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            wm.scanResults.forEach {
                Log.i("@codekul", "${it.SSID}")
            }
        }
    }

    val fltr = IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)

    val wm: WifiManager by lazy {
        applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wm.configuredNetworks.forEach {
            Log.i("@codekul", "${it.SSID}")
        }

        btScn.setOnClickListener {
            wm.startScan()
        }

        btCt.setOnClickListener {
            onConnect()
        }
    }

    override fun onStart() {
        super.onStart()

        registerReceiver(scnRcvr, fltr)
    }

    override fun onStop() {
        unregisterReceiver(scnRcvr)
        super.onStop()
    }

    fun onConnect() {
        val wifiConfig = WifiConfiguration()
        wifiConfig.SSID = String.format("\"%s\"", "YOG1234")
        wifiConfig.preSharedKey = String.format("\"%s\"", "1234567890")

        val netId = wm.addNetwork(wifiConfig)
        wm.disconnect()
        wm.enableNetwork(netId, true)
        wm.reconnect()
    }
}
