package chap08

class Person {
    lateinit var name: String

    fun test() {
        if(!::name.isInitialized) {
            println("not initialized")
        } else {
            println("initialized")
        }
    }
}

fun main() {
    val kildong = Person()

    // 초기화가 안됐는데 접근하면 exception발생
    println(kildong.name)
    kildong.test()
    kildong.name = "Kildong"
    kildong.test()
}