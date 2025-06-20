package org.example

import kotlin.math.abs

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
    val isEmptySpaces = trekk.contains("_")

    val countX = trekk.count{it == 'X'}
    val countO = trekk.count{it == 'O'}
    val hasTooManyOfSymbol = abs(countX - countO) >= 2

    for (verdierIVinnerposisjoner in verdierIVinnerposisjonerListe) {
        val vinnerPosisjonerString = verdierIVinnerposisjoner.joinToString("")
        if (vinnerPosisjonerString == "XXX"){
            hasXThreeInARow = true
        } else if (vinnerPosisjonerString == "OOO") {
            hasOThreeInARow = true
        }
    }

    if (hasTooManyOfSymbol) {
        println("Impossible")
    } else if (!hasXThreeInARow && !hasOThreeInARow) {
        if (isEmptySpaces) {
            println("Game not finished")
        } else {
            println("Draw")
        }
    } else {
        if (hasXThreeInARow && hasOThreeInARow) {
            println("Impossible")
        } else if (hasXThreeInARow) {
            println("X wins")
        } else {
            println("O wins")
        }
    }

    // vinnerindex: 0 1 2, 3 4 5, 6 7 8, 0 3 6, 1 4 7, 2 5 8, 0 4 8, 2 4 6
    // lagre vinnerindex i multidimensjonell liste
    // loope igjennom hver liste i lista
    // sjekke at input i disse indexene er kun X/O

}