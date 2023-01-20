package chap07

open class Person {
    constructor(firstName: String) {
        println("[Person] firstName: $firstName")
    }
    // 1
    constructor(firstName: String, age: Int) {
        println("[Person] firstName: $firstName, $age")
    }
}

class Developer: Person {
    // 3
    constructor(firstName: String): this(firstName, 10) {
        println("[Developer] $firstName")
    }
    // 2
    constructor(firstName: String, age: Int): super(firstName, age) {
        println("[Developer] $firstName, $age")
    }
}

fun main() {
    // 1
    val sean = Developer("Sean")
}