package chap10.limit

open class Animal(val size: Int) {

}

class Cat(val jump: Int): Animal(50)

class Spider(val poison: Boolean): Animal(1)

class Box<out T: Animal>(val element: T) {
    // out 일 경우 return Type에서만 가능하다
    // in일 경우 parameter Type에서만 가능하다
    fun getAnimal(): T = element
}

fun main() {
    val c1 = Cat(10)
    val s1 = Spider(true)

    var a1: Animal = c1
    a1 = s1
    // smart cast
    println("s1: ${a1.size}, ${a1.poison}")

    // 무변성
    // type 에 대한 내용을 정확히 정해줘야한다
    //val b1: Box<Animal> = Box<Animal>()
    //val b2: Box<Cat> = Box<Cat>()
    //val b3: Box<Spider> = Box<Spider>()

    // 공변성
    //val b11: Box<Animal> = Box<Cat>()
    //val b12: Box<Cat> = Box<Cat>()
    //val b13: Box<Spider> = Box<Spider>()

    // 제한할 경우 다른 클래스 안됨
    // val b14: Box<Number> = Box<Int>()
}