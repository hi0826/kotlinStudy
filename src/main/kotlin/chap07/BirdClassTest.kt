package chap07

// 생성자, 프로퍼티를 병합함
class Bird {

    var name: String
    var wing: Int
    var beak: String

    constructor(_name: String, _beak: String) {
        name = _name
        wing = 2
        beak = _beak
    }

    // _를 사용해서 정의할 수도 있음
    constructor(_name: String, _wing: Int, _beak: String) {
        name = _name
        wing = _wing
        beak = _beak
    }


    // 생성자 내에 다른 로직 처리를 하고 싶다
    /*
    init {
        // 기본 값이 들어감과 동시에 init 실행됨
        println("------- init start -------")
        name = name.capitalize()
        println("name: $name, wing: $wing, beak: $beak")
        println("------- init end ------")
    }
     */

    // method
    fun fly() {
        println("Fly")
    }

}

fun main() {
    val coco = Bird("coco", 2, "short")
    val coco2 = Bird("coco", "long")

    coco.fly()
    println(coco.name)
    println(coco.wing)
    println(coco.beak)

    println("coco2: name: ${coco2.name}, wing: ${coco2.wing}, beak: ${coco2.beak}")
}