package com.melayer.sqlite

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by aniruddha on 14/5/18.
 */
@Database(version = 1, entities = [(Car::class)])
abstract class AppDb : RoomDatabase() {

    companion object {
       private var appDb: AppDb? = null
        fun getInstance(context: Context): AppDb? {
            appDb = Room.databaseBuilder(context.applicationContext,
                    AppDb::class.java, "carDb").build()
            return appDb
        }
    }

    abstract fun carDao(): CarDao
}