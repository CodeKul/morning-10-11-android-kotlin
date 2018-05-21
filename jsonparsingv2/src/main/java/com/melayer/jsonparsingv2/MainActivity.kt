package com.melayer.jsonparsingv2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usinGson()
    }

    fun usinGson() {

        val gson = Gson()
        val mainObj = gson.fromJson(makeJson(), MainObj::class.java)
        Log.i("@codekul", "Name is ${mainObj.nm}")
        Log.i("@codekul", "Os is ${mainObj.os}")

        mainObj.list.forEach {
            Log.i("@codekul", "inventor is ${it.invt}")
        }
    }

    fun usingJSONObject() {

        val rtObj = JSONObject(makeJson())

        Log.i("@codekul", makeJson())
        Log.i("@codekul", "Os - ${rtObj.get("os")}")
        val inObj = rtObj.getJSONObject("obj")
        val invt = inObj.getString("invt")
        Log.i("@codekul", "Inventor - $invt")
        val list = rtObj.getJSONArray("list")
        for (i in 0 until (list.length() - 1)) {
            Log.i("@codekul", (list.get(i) as JSONObject).getString("age"))
        }
    }

    private fun makeJson(): String {
        return assets.open("my.json").bufferedReader().use {
            it.readText()
        }
    }
}
