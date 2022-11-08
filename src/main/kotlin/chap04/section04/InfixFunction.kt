package chap04.section04

fun main() {
    val num = 3
    // val str = num.strPlus("Kotlin")
    val str = num strPlus "Kotlin"
    println(str)
}

infix fun Int.strPlus(x: String): String {
    return "$x version $this"
}