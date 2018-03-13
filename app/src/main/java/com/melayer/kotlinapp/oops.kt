package com.melayer.kotlinapp

/**
 * Created by aniruddha on 13/3/18.
 */


class Mouse {

    private var txt: String = "hi"

    constructor(tx: String) {
        this.txt = tx
    }
}

val ms = Mouse("android")

class Car(
        private var pz: Int = 10
) {
    fun whtPz(nm : Int = 10) = pz * nm
}

fun main(args: Array<String>) {
    val cr = Car(15)
    println("Car prize is ${cr.whtPz()}")
    println("Car prize is ${cr.whtPz(89)}")
}
