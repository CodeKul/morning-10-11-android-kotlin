package com.melayer.webservices

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class WebApp : Application() {

    val gson : Gson by lazy {
        Gson()
    }

    val q : RequestQueue by lazy {
        Volley.newRequestQueue(this)
    }

    override fun onCreate() {
        super.onCreate()

        gson
        q
    }
}