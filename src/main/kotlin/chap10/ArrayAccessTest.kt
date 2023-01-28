package chap10

import java.util.*

fun main() {
    val arr = arrayOf(1, 2, 3, 4, 5)

    println(arr.get(0))
    println(arr[0])

    println(arr.size)

    for (ele in arr) {
        print(ele)
    }

    println(arr.contentToString())
    println(arr.sum())

    arr.set(1, 8)
    arr[1] = 8
}