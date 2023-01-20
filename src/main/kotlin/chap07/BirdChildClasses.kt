package chap07

open class BirdChild(var name: String, var wing: Int, var beak: String) {
    open fun fly() {
        println("Fly")
    }
}

class Lark(name: String, wing: Int, beak: String): BirdChild(name, wing, beak) {

    // fly 도 자동으로 상속
    override fun fly() {
        println("Quick Fly")
    }
    fun singHighton() {
        println("sing highton")
    }
}

class Parrot: BirdChild {
    var language: String
    constructor(name: String, wing: Int, beak: String, language: String): super(name, wing, beak) {
        this.language = language
    }

    override fun fly() {
        println("Slow Fly")
        super.fly()
    }

    fun speak() {
        println("speak $language")
    }
}

fun main() {
    val lark: BirdChild = Lark("myLark", 2, "short")
    val parrot: BirdChild = Parrot("myParrot", 2, "long", "English")

    println("lark - name: ${lark.name}")
    //println("parrot - name: ${parrot.name}, lang: ${parrot.language}")

    // lark.singHighton()
    lark.fly()

    // parrot.speak()
    parrot.fly()
}