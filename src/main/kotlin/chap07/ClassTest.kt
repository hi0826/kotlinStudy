package chap07

class Car {
    val wheel: Int = 4

    fun start() {
        println("Engine Start!")
    }
}


fun main() {
    // val sonata: Car = Car()
    val sonata = Car()
    println(sonata.wheel)
    sonata.start()
}