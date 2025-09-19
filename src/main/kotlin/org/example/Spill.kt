package org.example

import kotlin.math.abs

enum class SpillSymboler(val symbol: Char) {
    X('X'),
    O('O'),
    EMPTY_SPACE('_')
}

const val THREE_X = "XXX"
const val THREE_O = "OOO"

enum class SpillResultat(val result: String) {
    IMPOSSIBLE("Impossible"),
    GAME_NOT_FINISHED("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    ERROR_STATE("Error")


}

class Spill {
    fun beregnSpillResultat(boardState: String): SpillResultat {
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

        // TODO: Kanskje flytte til Board.kt
        val hasEmptySpaces = boardState.contains(SpillSymboler.EMPTY_SPACE.symbol)
        val countX = boardState.count { it == SpillSymboler.X.symbol }
        val countO = boardState.count { it == SpillSymboler.O.symbol }
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
            hasTooManyOfSymbol || (hasXThreeInARow && hasOThreeInARow) -> SpillResultat.IMPOSSIBLE
            !hasXThreeInARow && !hasOThreeInARow && hasEmptySpaces -> SpillResultat.GAME_NOT_FINISHED
            !hasXThreeInARow && !hasOThreeInARow -> SpillResultat.DRAW
            hasXThreeInARow -> SpillResultat.X_WINS
            hasOThreeInARow -> SpillResultat.O_WINS
            else -> SpillResultat.ERROR_STATE
        }
        return result
    }

    // TODO: Vi vil ikke sende inn boardState som string eller optional
    fun validerTrekk(trekk: String, boardState: String?): ValidationResult {
        val moveArray = trekk.split(" ")
        val yKoordinat = moveArray[0].toIntOrNull()
        val xKoordinat = moveArray[1].toIntOrNull()
        if (yKoordinat == null || xKoordinat == null) {
            return ValidationResult(false, -1, -1,"You should enter numbers!")
        }
        if (yKoordinat !in 1..3 || xKoordinat !in 1..3) {
            return ValidationResult(false, yKoordinat, xKoordinat, "Coordinates should be from 1 to 3!")
        }
        val isCellEmpty = isCellEmpty(yKoordinat, xKoordinat, boardState!!)

        return isCellEmpty
    }

    private fun isCellEmpty(yKoordinat: Int, xKoordinat: Int, boardState: String): ValidationResult {
        val boardState2dList = mutableListOf(
            mutableListOf<Char>(boardState[0], boardState[1], boardState[2]),   //[0]
            mutableListOf<Char>(boardState[3], boardState[4], boardState[5]),   //[1]
            mutableListOf<Char>(boardState[6], boardState[7], boardState[8])    //[2]
        )
        if (boardState2dList[xKoordinat - 1][yKoordinat - 1] != SpillSymboler.EMPTY_SPACE.symbol) {
            return ValidationResult(false, yKoordinat, xKoordinat, "This cell is occupied! Choose another one!")
        }
        return ValidationResult(true, yKoordinat, xKoordinat)
    }
}

data class ValidationResult(
    val isValid: Boolean,
    val yKoordinat: Int, // -1 betyr ugyldig
    val xKoordinat: Int, // -1 betyr ugyldig
    val message: String? = null
)