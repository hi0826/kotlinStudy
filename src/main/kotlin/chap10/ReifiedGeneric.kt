package chap10

import java.lang.IllegalStateException

fun main() {
    val result = getType<Float>(10)
    println("result = $result")
}

inline fun <reified T> getType(value: Int): T {
    // 실행 시간에 사라지지 않고 사용가능
    println(T::class)
    println(T::class.java)

    // 받아들인 제네릭 자료형에 따라 반환
    return when (T::class) {
        Float::class -> value.toFloat() as T
        Int::class -> value as T
        else -> throw IllegalStateException("${T::class} is not supported!!")
    }
}