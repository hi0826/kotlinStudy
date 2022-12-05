package chap08

class User(var _id: Int, _name: String, _age: Int) {
    val id: Int = _id
    private var tempName: String? = null
    var name: String = _name
        get() {
            if (tempName == null) tempName = "NONAME"
            return tempName ?: throw AssertionError("Asserted by others")
        }
        set(value) {
            println("the name was changed")
            field = value.toUpperCase()
        }

    var age: Int = _age
}

fun main() {
    val person = User(1, "Kildong", 30)
    person.name = "SBV";
    println("person.name = ${person.name}")
}