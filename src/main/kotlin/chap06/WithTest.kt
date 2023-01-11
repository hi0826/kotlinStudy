package chap06

fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)

    val user = User("Kildong", "default")

    println(user)

    val result = with (user) {
        // user.skills = "Kotlin"
        skills = "Kotlin"
        // user.email = "kildong@example.com"
        email = "kildong@example.com"
    }
    println(user)
    println("result: $result")
}