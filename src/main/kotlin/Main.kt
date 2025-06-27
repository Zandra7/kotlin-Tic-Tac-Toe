package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
const val EMPTY_SPACE = '_'
const val X = 'X'
const val O = 'O'
const val THREE_X = "XXX"
const val THREE_O = "OOO"

const val IMPOSSIBLE = "Impossible"
const val GAME_NOT_FINISHED = "Game not finished"
const val DRAW = "Draw"
const val X_WINS = "X wins"
const val O_WINS = "O wins"
const val ERROR_STATE = "Error"

fun main() {
    val trekk = readln()
    println("""
        ---------
        | ${trekk[0]} ${trekk[1]} ${trekk[2]} |
        | ${trekk[3]} ${trekk[4]} ${trekk[5]} |
        | ${trekk[6]} ${trekk[7]} ${trekk[8]} |
        ---------
    """.trimIndent())

    val spill = Spill()
    val result = spill.spillLogikk(trekk)
    println(result)

}