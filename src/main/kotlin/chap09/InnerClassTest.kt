package chap09

interface Switcher {
    fun on() : String
}

class Smartphone(val model: String) {
    private val cpu = "Exynos"

    inner class ExternalStroage(val size: Int) {
        fun getInfo() = "${model}: Installed on $cpu with ${size}Gb"
    }

    fun powerOn(): String {
        // 지역 클래스 선언
        class Led(val color: String) {
            // 외부의 프로퍼티는 접근 가능
            fun blink(): String = "Blinking $color on $model"
        }
        val powerStatus = Led("Red")
        val powerSwitch = object : Switcher {
            override fun on(): String {
                return powerStatus.blink()
            }
        }
        return powerSwitch.on()
    }
}

fun main() {
    val mySdcard = Smartphone("S7").ExternalStroage(32)
    println(mySdcard.getInfo())

    val myPhone = Smartphone("Note9")
    myPhone.ExternalStroage(128)
    println(myPhone.powerOn())
}