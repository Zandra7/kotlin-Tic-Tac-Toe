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
    val spill = Spill()
    val boardState = readln() // _XXOO_OX_
    val board = Board(boardState)
    board.printBoard()
    val spillTilstand = spill.hentSpillTilstand(boardState)

// --- loop
// Ta inn kordinater fra bruker

// Sjekke om det er 2 tall
    // Hvis ikke - print feilmelding og send tilbake til start av loop "You should enter numbers!"
// Sjekke om tallene er fra 1 - 3
    // Hvis ikke - print feilmelding og send tilbake til start av loop "Coordinates should be from 1 to 3!"
// Sjekke om cellen er tatt
// Hvis ikke - print feilmelding og send tilbake til start av loop "This cell is occupied! Choose another one!"
// ---

// Oppdater grid med nytt trekk
// Print den oppdaterte griden

    if (spillTilstand == GAME_NOT_FINISHED) {
        val trekk = readln()
        val result = spill.validerTrekk(trekk, boardState)
        if (!result.isValid) {
            println(result.message)
        } else {
            // Oppdater spillboard med trekk på posisjonen bruker har valgt

        }
    }
}