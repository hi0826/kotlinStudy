package chap05.section03

fun main() {
    retFunc()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("start of Func")
    inlineLambda(12, 3) {a, b ->
        val result = a + b
        // 암묵적 라벨
        if(result > 10) return@inlineLambda
        println("result : $result")
    }
    println("end of Func")
}