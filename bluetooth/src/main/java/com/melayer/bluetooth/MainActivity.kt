package com.melayer.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val btMgr by lazy {
        BluetoothAdapter.getDefaultAdapter()
    }

    private val scndRcvr = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val rmtDvc = intent?.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE) as BluetoothDevice
            Log.i("@codekul", "Name - ${rmtDvc.name}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(btMgr === null) {
            Log.i("@codekul", "Bluetooth is not supported to this device")
            return
        }
        if(!btMgr.isEnabled) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, 1234)
        }
        else {
            paired()

            registerReceiver( scndRcvr,IntentFilter(BluetoothDevice.ACTION_FOUND))
        }
    }

    private fun paired() {
        btMgr.bondedDevices.forEach {
            Log.i("@codekul", "Name ${it.name}")
        }
    }

    fun scan( vw : View) = btMgr.startDiscovery()
}
