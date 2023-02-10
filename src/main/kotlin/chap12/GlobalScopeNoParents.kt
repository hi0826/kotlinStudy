package chap12

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("runBlocking: $coroutineContext")
    val request = launch {
        println("request: $coroutineContext")
        GlobalScope.launch {
            println("job1: before suspend function, $coroutineContext")
            delay(1000)
            println("job1: after suspend function, $coroutineContext")
        }
        // launch { // 부모의 문맥을 상속
        launch(Dispatchers.Default) {
            delay(100)
            println("job12 before suspend function, $coroutineContext")
            delay(1000)
            println("job12 after suspend function, $coroutineContext")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("end")
}