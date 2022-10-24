package chap02.section03

fun main() {
    // null이 가능한 String
    var str1: String?
    str1 = null
    var str2: String? = "Hello"
    val len = str1?.length ?: -1
    // ?.은 safecall이라고 함, str1이 null이면 실행하지 않는다는 뜻
    // !!.은 null일리 없음을 의미, null check를 하지 않는다. ( 왠만하면 쓰지않는 것이 좋음 )
    println("str1 $str1 length: ${str1?.length}")
    println("str1 $str2 length: ${str2?.length}")
    // println("str1 $str1 length: ${str1!!.length}")
    println("str1 : $str1, length: $len")
}