package chap08

import kotlin.properties.Delegates

class User2 {
    var name: String by Delegates.observable("Noname") {
        prop, old, new ->
        println("old: $old, new: $new")
    }
}

fun main() {
    val user = User2()

    user.name = "kildong"
    user.name = "Dooly"

    var max: Int by Delegates.vetoable(0) {
        prop, old, new ->
        new > old
    }

    println(max)
    max = 10
    println(max)
    max = 5
    println(max)
}