package chap07

open class BirdChild(var name: String, var wing: Int, var beak: String) {
    fun fly() {
        println("Fly")
    }
}

class Lark(name: String, wing: Int, beak: String): BirdChild(name, wing, beak) {

    // fly 도 자동으로 상속
    fun singHighton() {
        println("sing highton")
    }
}

class Parrot: BirdChild {
    var language: String
    constructor(name: String, wing: Int, beak: String, language: String): super(name, wing, beak) {
        this.language = language
    }

    fun speak() {
        println("speak $language")
    }
}

fun main() {
    val lark = Lark("myLark", 2, "short")
    val parrot = Parrot("myParrot", 2, "long", "English")

    println("lark - name: ${lark.name}")
    println("parrot - name: ${parrot.name}, lang: ${parrot.language}")

    lark.singHighton()
    lark.fly()

    parrot.speak()
    parrot.fly()
}