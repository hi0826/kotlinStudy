package chap04.section02

fun sum(a: Int, b: Int) = a + b

fun mul(a: Int, b: Int): Int {
    return a * b
}

// 함수의 반환 형태도 함수도 사용가능
fun funcFunc(a: Int, b: Int) = sum(a, b)

fun main() {
    val result = sum(10, 10)
    val result2 = mul(sum(10, 5), 10)
    val result3 = funcFunc(2, 3)

    println("result: $result, result2: $result2, result3: $result3")
}