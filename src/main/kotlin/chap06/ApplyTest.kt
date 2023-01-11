package chap06

fun main() {
    // apply와 run 비교
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    // this > person
    person.apply { this.skills = "Swift" }
    println(person)

    val returnObj = person.apply {
        name = "Sean" // this 생략
        skills = "Java"
        "success" // 사용되지 않음
    }
    println(person)
    println(returnObj)

    val returnObj2 = person.run {
        this.name = "Dooly"
        this.skills = "C#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")
}