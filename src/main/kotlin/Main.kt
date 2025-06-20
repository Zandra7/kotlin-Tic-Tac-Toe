package org.example

import kotlin.math.abs

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

    // TODO: bedre navngivning
    val verdierIVinnerposisjonerListe = listOf(
        listOf(trekk[0], trekk[1], trekk[2]),
        listOf(trekk[3], trekk[4], trekk[5]),
        listOf(trekk[6], trekk[7], trekk[8]),
        listOf(trekk[0], trekk[3], trekk[6]),
        listOf(trekk[1], trekk[4], trekk[7]),
        listOf(trekk[2], trekk[5], trekk[8]),
        listOf(trekk[0], trekk[4], trekk[8]),
        listOf(trekk[2], trekk[4], trekk[6]),
    )

    var hasXThreeInARow = false
    var hasOThreeInARow = false

    val isEmptySpaces = trekk.contains(EMPTY_SPACE)
    val countX = trekk.count{it == X}
    val countO = trekk.count{it == O}
    val hasTooManyOfSymbol = abs(countX - countO) >= 2

    for (verdierIVinnerposisjoner in verdierIVinnerposisjonerListe) {
        val vinnerPosisjonerString = verdierIVinnerposisjoner.joinToString("")
        if (vinnerPosisjonerString == THREE_X){
            hasXThreeInARow = true
        } else if (vinnerPosisjonerString == THREE_O) {
            hasOThreeInARow = true
        }
    }

    val result = when {
        hasTooManyOfSymbol || (hasXThreeInARow && hasOThreeInARow) -> IMPOSSIBLE
        !hasXThreeInARow && !hasOThreeInARow && isEmptySpaces -> GAME_NOT_FINISHED
        !hasXThreeInARow && !hasOThreeInARow -> DRAW
        hasXThreeInARow -> X_WINS
        hasOThreeInARow -> O_WINS
        else -> ERROR_STATE
    }
    println(result)

}