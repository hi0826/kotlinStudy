package chap12

import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000L)
        doSomething()
        println("World")
    }
    println("Hello")
    Thread.sleep(2000L)
}

suspend fun doSomething() {
    println("Do something")
}