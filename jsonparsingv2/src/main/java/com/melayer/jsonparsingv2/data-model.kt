package com.melayer.jsonparsingv2

data class Obj(
        val invt: String,
        val age: Int
)

data class MainObj (
        val os : String,
        val nm : String,
        val vr : Int,
        val obj : Obj,
        val list : List<Obj> = ArrayList()
)