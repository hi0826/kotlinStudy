package chap04.section03

// 인라인함수는 람다식 형태를 취할 때 성능에 더 좋음
inline fun shortFunc(a: Int, crossinline out: (Int) -> Unit) {
    println("Hello")
    out(a)
    println("Good Bye")
}

fun main() {
    shortFunc(1, {a -> println("a: $a")})
    shortFunc(2) { a -> println("a: $a") }
    shortFunc(3, { println("a: $it") })
    shortFunc(4) { println("a: $it") }
    shortFunc(5) {
        println("a: $it")
    }
    shortFunc(6) {
        println("a: $it")
        // crossinline을 사용하면 return이 금지된다.
    }
}