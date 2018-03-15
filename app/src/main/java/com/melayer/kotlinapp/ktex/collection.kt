package com.melayer.kotlinapp.ktex

import com.melayer.samplelib.My

/**
 * Created by aniruddha on 15/3/18.
 */
fun list() {

    val lst = arrayListOf<String>()
    lst.add("Android")
    lst.add("Java")
    lst.add("C")
    lst.add("CPP")
    lst.add("Php")

    lst.forEach {
        println("element is $it ")
    }

    for (el in lst) {
        println("Element is $el")
    }

    for (i in 1..200) {
        println("the value i is $i ")
    }
}

fun map() {
    val map = mapOf(
            1 to "Android",
            2 to "Java",
            3 to "Php",
            4 to "Jsp"
    )

    map.forEach { (t, u) -> println("Key - $t Value - $u") }

    val mp = hashMapOf<Int, String>()
    mp[1] = "Java"
    mp[2] = "Kotlin"
    mp[3] = "Php"
    mp[4] = "Ruby"

    mp.forEach { (key, vals) -> println("Key is $key Value is $vals") }
    mp.forEach({ (key, vals) -> println("Key is $key Value is $vals") })
//    mp.forEach(fun(key, vals) {
//        println("Key is $key Value is $vals")
//    })
}

fun set() {
    val st = hashSetOf<String>()
    st.add("Android")
    st.add("Android")
    st.add("Java")

    st.forEach { println(it) }
}

fun main(args: Array<String>) {
    set()

    val my = My()
}