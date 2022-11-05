package chap04.section01

fun main() {
    val result: Int

    // 일반 변수에 람다식 할당
    // val multi = { a: Int, b: Int -> a * b }
    //val multi: (a: Int, b: Int) -> Int = { a, b -> a * b }
    val multi: (a: Int, b: Int) -> Int = { a, b ->
        println("a: $a, b: $b")
        a * b
        // a*b를 지울경우 반환값이 없어지므로 Unit으로 변경해야함
    }

    // val nestedLambda = { { println("nested") } }
    val nestedLambda: () -> () -> Unit = { { println("nested") } }

    result = multi(10, 20)
    println(result)
    nestedLambda();
}