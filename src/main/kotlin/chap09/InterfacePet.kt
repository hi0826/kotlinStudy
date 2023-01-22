package chap09

interface Pet {
    // 추상 프로퍼티
    var category: String
    val msgTags: String
        get() = "I'm your lovely pet!"

    // 추상 메서드
    fun feeding()

    // 일반 메서드
    fun patting() {
        // 구현부
        println("Keep patting")
    }
}

class Cat(override var category: String): Pet {
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("small")
    println("Pet Category: ${obj.category}")
    obj.feeding()
    obj.patting()
    println("Pet Message: ${obj.msgTags}")
}