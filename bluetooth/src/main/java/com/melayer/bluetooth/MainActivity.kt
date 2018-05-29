package com.melayer.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.system.Os.accept
import android.bluetooth.BluetoothSocket
import android.bluetooth.BluetoothServerSocket
import android.view.View
import java.io.DataInputStream
import java.io.DataInputStream.readUTF
import java.io.DataOutputStream
import java.io.IOException
import java.util.*
import java.lang.reflect.AccessibleObject.setAccessible
import java.lang.reflect.InvocationTargetException


class MainActivity : AppCompatActivity() {

    private val onFndRcvr = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val rmtDv = intent?.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE) as BluetoothDevice

            Log.i("@codekul", "Name - ${rmtDv.name}")
        }
    }
    private val btMgr by lazy {
        BluetoothAdapter.getDefaultAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!btMgr.isEnabled) {
            Log.i("@codekul", "Starting bluetooth in moment")
            btMgr.enable()
        }
        else {
            Log.i("@codekul", "Bluetooth Already Enabled")
            Log.i("@codekul", "My Bid ${getBluetoothMacAddress()}")
            btMgr.bondedDevices.forEach {
                Log.i("@codekul", it.name)
            }
        }

        btScn.setOnClickListener {
            btMgr.startDiscovery()
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(onFndRcvr, IntentFilter(BluetoothDevice.ACTION_FOUND))
    }

    override fun onStop() {
        unregisterReceiver(onFndRcvr)
        super.onStop()
    }

    fun onServer(view: View) {

        Thread(Runnable {
            try {
                val bss = btMgr.listenUsingRfcommWithServiceRecord(
                        "chatservice",
                        UUID.fromString("00000000-0000-1000-8000-00805F9B34FB")
                )

                val socket = bss.accept()
                val dos = DataOutputStream(socket.outputStream)
                dos.writeUTF("This is hi from Bt Server")

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }).start()
    }

    fun onClient(view: View) {

        Thread(Runnable {
            val device = btMgr.getRemoteDevice("84:10:0D:A1:08:ED")
            try {
                val socket = device.createRfcommSocketToServiceRecord(
                        UUID.fromString("00000000-0000-1000-8000-00805F9B34FB")
                )
                socket.connect()
                val dis = DataInputStream(socket.inputStream)
                val data = dis.readUTF()
                Log.i("@codekul", "Data from server - $data")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }).start()
    }

    private fun getBluetoothMacAddress(): String {
        val bluetoothAdapter = btMgr
        var bluetoothMacAddress = ""
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            try {
                val mServiceField = bluetoothAdapter.javaClass.getDeclaredField("mService")
                mServiceField.isAccessible = true

                val btManagerService = mServiceField.get(bluetoothAdapter)

                if (btManagerService != null) {
                    bluetoothMacAddress = btManagerService.javaClass.getMethod("getAddress").invoke(btManagerService) as String
                }
            } catch (e: NoSuchFieldException) {

            } catch (e: NoSuchMethodException) {

            } catch (e: IllegalAccessException) {

            } catch (e: InvocationTargetException) {

            }

        } else {
            bluetoothMacAddress = bluetoothAdapter.address
        }
        return bluetoothMacAddress
    }


}
