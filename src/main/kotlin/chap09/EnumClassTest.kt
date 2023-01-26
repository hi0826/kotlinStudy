package chap09

interface Score {
    fun getScore(): Int
}

enum class MemberType(var prio: String): Score {
    NORMAR("Third") {
        override fun getScore(): Int = 100
    },
    SILVER("Second") {
        override fun getScore(): Int = 500
    },
    GOLD("First") {
        override fun getScore(): Int = 1500
    }
}

fun main() {
    println(MemberType.NORMAR.getScore())
    println(MemberType.GOLD)
    println(MemberType.valueOf("SILVER"))
    println(MemberType.SILVER.prio)
    for(grade in MemberType.values()) {
        println("gradeName: ${grade.name}, prio: ${grade.prio}")
    }
}