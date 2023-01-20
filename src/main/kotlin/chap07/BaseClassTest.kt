package chap07

open class Base {
    // 상속 계열에서만 접근 가능
    protected var i = 1
    protected fun protectedFunc() {
        i += 1
        println(i)
    }
    fun access() {
        protectedFunc()
    }
}

class Derived: Base() {
    var j = 1 + i
    fun derivedFunc(): Int {
        protectedFunc()
        return i
    }
}

class Other {
    fun other() {
        val base = Base()
        // protected 여서 실패
        // base.i = 3
    }
}

fun main() {
    val base = Base()
    // base.i
    // base.protectedFunc
    base.access()

    val derived = Derived()
    derived.j = 3
    derived.derivedFunc()
}