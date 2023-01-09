package chap06

fun main() {
    val score: Int? = 32

    // null check
    fun checkScore() {
        if (score != null) {
            println("Score: $score")
        }
    }

    // using let null check
    fun checkScoreLet() {
        score?.let { println("Score: $it") }
        val str = score.let { it.toString() }
        println(str)
    }

    checkScore()
    checkScoreLet()
}