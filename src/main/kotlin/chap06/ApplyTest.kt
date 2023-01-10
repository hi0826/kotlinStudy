package chap06

fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    // this > person
    person.apply { this.skills = "Swift" }
    println(person)

    val returnObj = person.apply {
        name = "Sean" // this 생략
        skills = "Java"
    }
    println(person)
    println(returnObj)
}