package com.melayer.intrnlstrg

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

typealias myIs = Int

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("@codekul", "Internal Storage $filesDir")
        Log.i("@codekul", "Cache Storage $cacheDir")

        store()

        retrieve()

        filesDir.list().forEach {
            Log.i("@codekul", "file is $it")
        }

        filesDir.parentFile.list().forEach {
            Log.i("@codekul", "file is $it")
        }
    }

    private fun store() {
        openFileOutput("my.txt", Context.MODE_PRIVATE).use {
            it.write("Hello and welcome to codekul".toByteArray())
        }
    }

    private fun retrieve() {

        val isp = openFileInput("my.txt")
        val dt = isp.bufferedReader().use {
            it.readLine()
        }
        Log.i("@codekul", "Data is $dt")
    }
}
