package org.example

import kotlin.math.abs

class Spill {
    fun spillLogikk(boardState: String): String {
        val vinnerKombinasjoner = listOf(
            listOf(boardState[0], boardState[1], boardState[2]),
            listOf(boardState[3], boardState[4], boardState[5]),
            listOf(boardState[6], boardState[7], boardState[8]),
            listOf(boardState[0], boardState[3], boardState[6]),
            listOf(boardState[1], boardState[4], boardState[7]),
            listOf(boardState[2], boardState[5], boardState[8]),
            listOf(boardState[0], boardState[4], boardState[8]),
            listOf(boardState[2], boardState[4], boardState[6]),
        )

        var hasXThreeInARow = false
        var hasOThreeInARow = false

        val isEmptySpaces = boardState.contains(EMPTY_SPACE)
        val countX = boardState.count { it == X }
        val countO = boardState.count { it == O }
        val hasTooManyOfSymbol = abs(countX - countO) >= 2

        for (verdierIVinnerposisjoner in vinnerKombinasjoner) {
            val vinnerPosisjonerString = verdierIVinnerposisjoner.joinToString("")
            if (vinnerPosisjonerString == THREE_X) {
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
        return result
    }

    fun printGrid(boardState: String) {
        println(
            """
        ---------
        | ${boardState[0]} ${boardState[1]} ${boardState[2]} |
        | ${boardState[3]} ${boardState[4]} ${boardState[5]} |
        | ${boardState[6]} ${boardState[7]} ${boardState[8]} |
        ---------
    """.trimIndent()
        )
    }

    // TODO: mye bedre løsning enn hvordan vi tar inn board state
    fun isValidInput(move: String, boardState: String = ""): ValidationResult {
        val moveArray = move.split(" ")
        val yKordinat = moveArray[0].toIntOrNull()
        val xKordinat = moveArray[1].toIntOrNull()
        if (yKordinat == null || xKordinat == null) {
            return ValidationResult(false, yKordinat, xKordinat,"You should enter numbers!")
        }
        if (yKordinat !in 1..3 || xKordinat !in 1..3) {
            return ValidationResult(false, yKordinat, xKordinat, "Coordinates should be from 1 to 3!")
        }
        val isCellEmpty = isCellEmpty(yKordinat, xKordinat, boardState)
        return ValidationResult(true, yKordinat, xKordinat)
    }

    fun isCellEmpty(yKordinat: Int, xKordinat: Int, boardState: String): ValidationResult {
        val boardState2dList = mutableListOf(
            mutableListOf<Char>(boardState[0], boardState[1], boardState[2]),   //[0]
            mutableListOf<Char>(boardState[3], boardState[4], boardState[5]),    //[1]
            mutableListOf<Char>(boardState[6], boardState[7], boardState[8])    //[2]
        )
        if (boardState2dList[xKordinat][yKordinat] != EMPTY_SPACE) {
            return ValidationResult(false, yKordinat, xKordinat, "This cell is occupied! Choose another one!")
        }
        return ValidationResult(true, yKordinat, xKordinat)
    }
}

// TODO: vi trenger ikke optional på x og y koordinat når input er ugyldig
data class ValidationResult(
    val isValid: Boolean,
    val yKordinat: Int? = null,
    val xKordinat: Int? = null,
    val message: String? = null
)