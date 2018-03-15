package com.melayer.kotlinapp.ktex

/**
 * Created by aniruddha on 9/3/18.
 */

var nm: Any = "android"

var obj = object {
    val nmHi = 10
    val ftHi = ""

    fun dtTm(): String {
        return ""
    }
}


val proj = 10

fun hi(): String {
    nm = 10
    nm = String()
    return "codekul"
}

fun inlineHi() = "codekul"

val strDta = """
        Hello this is codekul everything is ${nm} and
        i am going to next line ${inlineHi()}
""".trimIndent()

val car = Car() // new Car()
fun carFn() {
}


fun main(args: Array<String>) {

    fn(10)

    val hq = fn

    funDemo {
        true
    }
}