package com.melayer.sqlite

import android.app.Application
import android.arch.persistence.room.Room



/**
 * Created by aniruddha on 14/5/18.
 */
class DbApp : Application() {

    val dbApp : AppDb by lazy {
        Room.databaseBuilder(this@DbApp,
                AppDb::class.java, "carDb").build()
    }

    override fun onCreate() {
        super.onCreate()

        dbApp
    }
}