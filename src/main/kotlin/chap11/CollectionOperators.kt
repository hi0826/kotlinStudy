package chap11

import finalPj01.playerInput

fun main() {
    val list1 = listOf("one", "two", "three")
    val list2: List<Int> = listOf(1, 2, 3)

    // 새로운 컬렉션이 됨
    println(list1 + "four")
    println(list2 + "hello")
    println(list2 - 1)
    println(list1 - "one")

    println(list1 + listOf("abc", "def"))
}