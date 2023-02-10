package chap12

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            doSomething()
            println("World")
        }
        println("Hello")
        println("job: ${job.isActive}, ${job.isCompleted}")
        // Thread.sleep(2000L)
        job.join()
        println("job: ${job.isActive}, ${job.isCompleted}")
    }
}

suspend fun doSomething() {
    println("Do something")
}