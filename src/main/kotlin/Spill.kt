package org.example

import kotlin.math.abs

class Spill {
    fun spillLogikk(trekk: String): String {
        val vinnerKombinasjoner = listOf(
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
        val countX = trekk.count { it == X }
        val countO = trekk.count { it == O }
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
}