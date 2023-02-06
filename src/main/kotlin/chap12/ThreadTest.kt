package chap12

// thread 생성 방법
// class
class SimpleThread: Thread() {
    override fun run() {
        println("Class Thread ${Thread.currentThread()}")
    }
}
// interface
class SimpleRunnable: Runnable {
    override fun run() {
        println("Interface Thread ${Thread.currentThread()}")
    }

}

fun main() {
    val thread = SimpleThread()

    thread.start()

    val runnable = SimpleRunnable()
    val thread2  = Thread(runnable)
    thread2.start()

    // 익명객체
    object: Thread() {
        override fun run() {
            println("Object Thread: ${Thread.currentThread()}")
        }
    }.start()

    // 람다식
    Thread {
        println("Lambda Thread: ${Thread.currentThread()}")
    }.start()
}