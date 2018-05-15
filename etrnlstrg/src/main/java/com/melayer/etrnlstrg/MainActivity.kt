package com.melayer.etrnlstrg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        writeToPublic()

        readPublic()

        Log.i("@codekul", "External Storage Path ${getExternalFilesDir("codekul")}")
        Log.i("@codekul", "External Public Storage ${Environment.getExternalStoragePublicDirectory("codekul")}")
    }

    fun writeToPublic() {
        Log.i("@codekul", (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED).toString())
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val fl = File(
                    Environment.getExternalStoragePublicDirectory(""),
                    "my.txt"
            )
            fl.createNewFile()
            FileOutputStream(fl).use {
                it.write("Welcome codekul.com".toByteArray())
            }
        } else {
            Toast.makeText(this@MainActivity, "Storage Not Found", Toast.LENGTH_SHORT).show()
        }
    }

    fun readPublic() {
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val fl = File(
                    Environment.getExternalStoragePublicDirectory(""),
                    "my.txt"
            )
            val dt = FileInputStream(fl).bufferedReader().use {
                it.readLine()
            }
            Log.i("@codekul", "Data written is $dt ")

        } else {
            Toast.makeText(this@MainActivity, "Storage Not Found", Toast.LENGTH_SHORT).show()
        }
    }
}
