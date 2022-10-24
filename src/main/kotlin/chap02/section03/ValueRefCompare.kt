package chap02.section03

fun main() {
    val a: Int = 128
    val b = a

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    println(a === b)
    println(c == d)
    println(c === d)
    println(c === e)

}