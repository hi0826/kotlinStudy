package chap05.section1

fun main() {
    print("Enter the score: ")
    // !! 을 사용해서 not null을 단정 지음
    val score = readLine()!!.toDouble()
    var grade : Char = 'F'

    if (score >= 90.0) {
        grade = 'A'
    } else if (score in 80.0..89.9) {
        grade = 'B'
    } else if (score in 70.0..79.9) {
        grade = 'C'
    }

    println("score : $score, grade: $grade")
}