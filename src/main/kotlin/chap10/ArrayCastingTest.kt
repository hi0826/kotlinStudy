package chap10

fun main() {
    val b = Array<Any>(10, { 0 })
    // type mismatching
    // 자료형 제한을 통해서 확장 가능
    b[0] = "Hello World"
    b[1] = 1.2
    println(b.contentToString())
}