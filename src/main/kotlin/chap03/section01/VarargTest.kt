package chap03.section01

fun normalVarargs(vararg a: Int) {
    for (num in a) {
        print("$num ")
    }
}

fun main() {
    normalVarargs(1)
    normalVarargs(1, 2, 3, 4, 5, 6, 7)
}