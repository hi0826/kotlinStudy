package chap06

import java.io.FileOutputStream
import java.io.PrintWriter

fun main() {
    // use 에 open, write, close가 다 된다.
    PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
        it.println("hello")
    }
}