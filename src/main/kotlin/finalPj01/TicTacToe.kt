package finalPj01

import java.util.*

fun main() {
    // 메인 보드 생성 3 * 3
    // 보드 초기화(함수)
    // 플레이어 배열 선언
    // 말 배열 선언
    // 게임 진행

    play()
}

fun initBoard(): Array<Array<String>> {
    return Array(3) {Array(3) { " " }}
}

fun printBoard(turn:Int, board:Array<Array<String>>) {
    println(" $turn 번째 턴")
    println("   0  1  2")
    for(row in 0..2) {
        println("$row ${board[row][0]} | ${board[row][1]} | ${board[row][2]} ")
        if(row != 2) {
            println("  --+--+--")
        }
    }
}

fun isInRange(y: Int, x: Int, board:Array<Array<String>>): Boolean {
    when {
        y < 0 -> return false
        y > 2 -> return false
        x < 0 -> return false
        x > 2 -> return false
        board[y][x] != " " -> return false
    }
    return true;
}

fun playerInput(player: Int): List<String>? {
    print("Player $player 입력(줄, 칸): ")
    val input = readLine()
    return input?.split(",")
}

fun isWin(player: Int, board: Array<Array<String>>): Boolean {
    when(player) {
        1 -> {

        }
        2 -> {

        }
    }
    return false;
}

fun play() {
    var board = initBoard()
    var turn = 1
    var player = 1
    while(true) {
        printBoard(turn, board)
        val yx = playerInput(player)
        val y: Int = yx?.get(0)?.toInt() ?: 0
        val x: Int = yx?.get(1)?.toInt() ?: 0

        if(!isInRange(y, x, board)) {
            println("범위에 맞지 않습니다.")
            continue
        }

        if(player == 1) {
            board[y][x] = "O"
            if(isWin(player, board)) {
                break
            }
            player = 2
        } else {
            board[y][x] = "X"
            if(isWin(player, board)) {
                break
            }
            player = 1
        }

        turn++
    }
}