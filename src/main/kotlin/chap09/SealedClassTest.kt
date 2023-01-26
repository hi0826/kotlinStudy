package chap09

sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
}

fun main() {
    val result = Result.Success("Success")
    val errorResult = Result.Error(10, "No disk")
    println(eval(result))
    println(eval(errorResult))
}

fun eval(result: Result): String = when(result) {
    is Result.Success -> result.message
    is Result.Error -> result.message
}