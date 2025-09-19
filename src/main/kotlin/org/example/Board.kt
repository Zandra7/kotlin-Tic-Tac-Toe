package org.example

class Board(val boardState: String) {
    private val boardState2dList = mutableListOf(
        mutableListOf<Char>(boardState[0], boardState[1], boardState[2]),   //[0]
        mutableListOf<Char>(boardState[3], boardState[4], boardState[5]),   //[1]
        mutableListOf<Char>(boardState[6], boardState[7], boardState[8])    //[2]
    )

    // TODO: Implementer 'oppdater board'

    fun printBoard() {
        println(
            """
        ---------
        | ${boardState2dList[0][0]} ${boardState2dList[0][1]} ${boardState2dList[0][2]} |
        | ${boardState2dList[1][0]} ${boardState2dList[1][1]} ${boardState2dList[1][2]} |
        | ${boardState2dList[2][0]} ${boardState2dList[2][1]} ${boardState2dList[2][2]} |
        ---------
    """.trimIndent()
        )
    }

    fun isCellEmpty(yKoordinat: Int, xKoordinat: Int): ValidationResult {
        if (boardState2dList[xKoordinat - 1][yKoordinat - 1] != SpillSymboler.EMPTY_SPACE.symbol) {
            return ValidationResult(false, yKoordinat, xKoordinat, "This cell is occupied! Choose another one!")
        }
        return ValidationResult(true, yKoordinat, xKoordinat)
    }
}