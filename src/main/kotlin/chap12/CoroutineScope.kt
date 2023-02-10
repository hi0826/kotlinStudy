package chap12

import kotlinx.coroutines.*

fun main() = runBlocking(Dispatchers.Default) {

    //runBlocking에 있는걸 상속 받음 (인자 없음)
    launch(Dispatchers.IO) {
        delay(1200L)
        println("Task from runBlocking")
    }

    // new scope
    coroutineScope {
        launch {
            delay(1500L)
            println("Task from nested launch")
        }
        delay(200L)
        println("Task from coroutineScope")
    }

    println("end of runBlocking")
}