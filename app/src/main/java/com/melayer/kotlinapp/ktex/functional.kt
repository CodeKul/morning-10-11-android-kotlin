package com.melayer.kotlinapp.ktex

/**
 * Created by aniruddha on 12/3/18.
 */
val fn: (num1: Int) -> Unit = fun(num1: Int) {
    println("Number is $num1 ")
}

val fn1: (num1: Int) -> Unit = { a -> println("Value is $a") }

fun funDemo(cb: (num1: Int) -> Boolean) {
    cb(10)
}

fun callDemo() {

    funDemo(fun(_): Boolean {
        return true
    })

    funDemo({ _ -> true })

    funDemo {
        println(" value of int is $it")
        true
    }
}

fun funDemo1(): () -> Unit {
    return fun() {

    }
}

fun fn2(): () -> Unit {
    return  {

    }
}


