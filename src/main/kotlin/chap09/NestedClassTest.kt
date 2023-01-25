package chap09

class Outer {
    val ov = 5
    class Nested {
        val nv = 10
        // 내부에서 외부로 접근 안됨 ( ov 접근 불가능 )
        fun greeting() = "[Nested] Hello ! $nv"
        fun accessOuter() {
            println(country)
            getSomething()
        }
    }
    fun outside() {
        val msg = Nested().greeting()
        // 외부에서 접근은 가능
        println("[Outer]: $msg, ${Nested().nv}")
    }

    // compainion 객체는 static처럼 접근 가능
    companion object {
        const val country = "Korea"
        fun getSomething() = println("Get something..")
    }
}

fun main() {
    // static 처럼 Outer의 객체 생성 없이 접근 가능
    val output = Outer.Nested().greeting()
    println(output)
    Outer.Nested().accessOuter()

    // Outer.outside()는 불가능
    val outer = Outer()
    outer.outside()
}