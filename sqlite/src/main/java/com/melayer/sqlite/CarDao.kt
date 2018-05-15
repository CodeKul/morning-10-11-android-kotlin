package com.melayer.sqlite

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by aniruddha on 14/5/18.
 */
@Dao
interface CarDao {

    @Insert
    fun insert(cr : Car)

    @Query("select * from car")
    fun  cars() : List<Car>
}