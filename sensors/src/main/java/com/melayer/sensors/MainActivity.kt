package com.melayer.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lsnr = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        }

        override fun onSensorChanged(event: SensorEvent) {
            val dtx = event.values[0]
            val dty = event.values[1]
            val dtz = event.values[2]

            txtDt.text = """
                x $dtx
                y $dty
                z $dtz
            """.trimMargin()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mgr = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lst = mgr.getSensorList(Sensor.TYPE_ALL)
        lst.forEach {
            txtDt.append(it.name)
            txtDt.append("\n")
            txtDt.append("\n-------")
        }
        //mgr.registerListener(lsnr, mgr.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL)
        //mgr.registerListener(lsnr, mgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
    }
}
