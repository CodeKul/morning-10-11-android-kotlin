package com.melayer.sqlite

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aniruddha on 14/5/18.
 */
@Entity
data class Car(

        @PrimaryKey
        var crId: Long,

        @ColumnInfo(name = "car_name")
        var crNm: String,

        @ColumnInfo(name = "car_onr")
        var crOnr: String
)