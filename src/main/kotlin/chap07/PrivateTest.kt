package chap07

private class PrivateTest {
    private var i = 1
    private fun privateFunc() {
        i += 1
        println(i)
    }
    // default public
    fun access() {
        privateFunc()
    }
}

class OtherClass {
    // 외부에 공개하지 않는 조건으로 생성하면 생성이 됨
    // [private] val pc = PrivateTest()
    fun test() {
        val pc = PrivateTest()
        pc.access()
    }
}

fun main() {
    // top level method에서는 생성 가능
    val pc = PrivateTest()

    // error i가 private
    // pc.i = 3

    // error privateFunc가 private
    // pc.privateFunc()

    pc.access()
}

fun TopFunction() {
    val tpc = PrivateTest()
}