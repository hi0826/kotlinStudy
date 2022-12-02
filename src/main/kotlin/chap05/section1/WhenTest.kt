package chap05.section1

fun main() {
    print("Enter the score: ")
    // !! 을 사용해서 not null을 단정 지음
    val score = readLine()!!.toDouble()
    var grade : Char = 'F'

    // if 보다 간략하게 구성 가능
    when (score) {
        in 90.0..100.0 -> grade = 'A'
        in 80.0..89.9 -> grade = 'B'
        in 70.0..79.9 -> grade = 'C'
        else -> grade = 'F'
    }

    println("score : $score, grade: $grade")
}