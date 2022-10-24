package chap02.section04

fun main() {
    val x = 4 // 0100(2) 4(10)
    val y = 0b0000_1010 // 5(10)
    val z = 0x0f // 0b0000_1111(2) 15(10)

    println("x shl 2 -> ${x.shl(2)}")
    println("x shl 2 -> ${x shl 2}") // 0001_0000(2) 16(10)

    println("x inv -> ${x.inv()}") // 1111....1011(2) -5(10)
}