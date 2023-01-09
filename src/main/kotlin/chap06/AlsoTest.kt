package chap06

fun main() {

    data class Person(var name: String, var skills: String)
    val person = Person("Kildong", "Kotlin")

    /*
    val a = person.let {
        it.skills = "Java"
        "Success"
    }
     */

    val a = person.also {
        it.skills = "Java"
        "Success"
    }
    println("a $a") // Success
    println("person $person") // person.skills = Java

}