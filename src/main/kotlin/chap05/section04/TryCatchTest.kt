package chap05.section04

fun main() {
    val a = 6
    val b = 0
    val c: Int

    try {
        println("Before")
        c = a / b
        println("After")
    } catch(e: ArithmeticException) {
        println("Exception")
    } finally {
        println("Finally")
    }
}