package chap08

class LazyTest {
    init {
        println("init block")
    }

    private val subject by lazy {
        println("lazy Initialized")
        "Kotlin Programming"
    }
    fun flow() {
        println("not init")
        println("subject one: $subject")
        println("subject two: $subject")
    }
}

fun main() {
    val test = LazyTest()
    test.flow()
}