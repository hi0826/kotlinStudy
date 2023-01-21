package chap09

abstract class Vehicle(val name: String, val color: String, val weight: Double) {

    //추상 프로퍼티 - 하위에서 반드시 오버라이딩해야함
    abstract val maxSpeed: Double

    // 비추상 프로퍼티
    var year: String = "2008"

    // 추상 메서드
    abstract fun start()

    abstract fun stop()

    // 비추상 메서드
    fun displaySpec() {
        println("name: $name, color: $color, weight: $weight, year: $year, maxSpeed: $maxSpeed")
    }
}

class Car(name: String,
          color: String,
          weight: Double,
          override val maxSpeed: Double) : Vehicle(name, color, weight) {
    override fun start() {
        println("Car Started")
    }

    override fun stop() {
        println("Car Stopped")
    }

    fun autoPilotOn() {
        println("Auto Pilot On")
    }
}


class Motorbike(name: String,
          color: String,
          weight: Double,
          override val maxSpeed: Double) : Vehicle(name, color, weight) {
    override fun start() {
        println("Motorbike Started")
    }

    override fun stop() {
        println("Motorbike Stopped")
    }
}

fun main() {
    val car = Car("Matiz", "red", 1000.0, 100.0)
    // 추상클래스는 생성 불가 val v = Vehicle("Ve", "red", 1000.0)
    val motorbike = Motorbike("motor1", "blue", 100.0, 120.0)

    car.year = "2014"
    car.displaySpec()

    motorbike.year = "2017"
    motorbike.displaySpec()

    car.start()
    motorbike.start()

}