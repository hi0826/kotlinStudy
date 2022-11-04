package chap03.section01

fun sum(a: Int, b: Int) = a + b

fun max(a: Int, b: Int) = if (a > b) a else b

fun outfunc(name: String) = println("Name: $name")

fun main() { // 최상위 함수
    val result1 = sum(2,3)
    println(result1)

    val a = 3
    val b = 5
    val result2 = max(a, b)
    println(result2)
    outfunc("Kildong")
}