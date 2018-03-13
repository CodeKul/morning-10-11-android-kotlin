package com.melayer.kotlinapp

/**
 * Created by aniruddha on 13/3/18.
 */

class Mouse {

    private var txt: String = "hi"

    constructor(tx: String) {
        this.txt = tx
    }

    fun myFn(vararg  string : String){
        for(str in string) {
            println(str)
        }
    }
}


interface  Gps {
    fun locate()
}

open class Car(
        private var pz: Int = 10
) {
    fun whtPz(nm : Int = 10) = pz * nm
}

class Bmw(
        private var pz : Int = 56,
        private var spd  : Float
) : Gps, Car(pz) {

    override fun locate() {
    }

    infix fun whtSp(nm : Int)  = pz * spd
}

fun main(args: Array<String>) {
    val cr = Car(15)
    println("Car prize is ${cr.whtPz()}")
    println("Car prize is ${cr.whtPz(89)}")

    val bmw = Bmw (0,900f)
    println("Speed is ${bmw.whtSp(89)} and prize is ${bmw.whtPz()}")
    bmw whtSp 89

    var gp : Gps = object : Gps {
        override fun locate() {
        }
    }

    gp = bmw

    val ms = Mouse("android")
    ms.myFn("hello")
    ms.myFn("one","two")
    ms.myFn("one","two","three")
    ms.myFn()
}
