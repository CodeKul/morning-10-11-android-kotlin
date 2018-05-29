package com.codekul.snsr

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val sm: SensorManager by lazy {
        this@MainActivity
                .getSystemService(
                        android.content.Context.SENSOR_SERVICE
                ) as SensorManager
    }

    val sl: SensorEventListener by lazy {
        object : SensorEventListener {
            override fun onAccuracyChanged(
                    sensor: Sensor?, accuracy: Int
            ) {
            }

            override fun onSensorChanged(
                    event: SensorEvent?
            ) {
                //txtDt.text = event!!.values[0].toString()
                txtDt.text = """
                    X - ${event!!.values[0]},
                    Y - ${event!!.values[1]},
                    Z - ${event!!.values[2]},
                """.trimIndent()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lst = sm.getSensorList(Sensor.TYPE_ALL)
        lst.forEach {
            Log.i("@codekul", it.name)
        }

        proximity()
    }

    fun proximity() {
        val snsr = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        sm.registerListener(sl, snsr, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun aclmtr() {
        val snsr = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sm.registerListener(sl, snsr, SensorManager.SENSOR_DELAY_NORMAL)
    }
}
