package com.melayer.sqlite

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by aniruddha on 14/5/18.
 */
@Database(version = 1, entities = [(Car::class)])
abstract class AppDb : RoomDatabase(){

    abstract fun carDao() : CarDao
}