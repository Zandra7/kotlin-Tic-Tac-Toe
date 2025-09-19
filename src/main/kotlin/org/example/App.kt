package org.example
// TODO: Gjør til Norsk

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


fun main() {
    val boardState = readln() // _XXOO_OX_
    val board = Board(boardState)
    val spill = Spill(board)
    board.printBoard()
    val spillResultat = spill.beregnSpillResultat(boardState)

    if (spillResultat == SpillResultat.GAME_NOT_FINISHED) {
        val trekk = readln() // 1 1
        val validerTrekkResultat = spill.validerTrekk(trekk, boardState)
        if (!validerTrekkResultat.isValid) {
            println(validerTrekkResultat.message)
            // TODO: Loop som ber bruker skrive koordinat på nytt til det blir 'isValid = true'
        } else {
            // TODO: Oppdater grid med nytt trekk og print til konsoll
        }
    }

// --- loop
// Ta inn kordinater fra bruker

// Sjekke om det er 2 tall
    // Hvis ikke - print feilmelding og send tilbake til start av loop "You should enter numbers!"
// Sjekke om tallene er fra 1 - 3
    // Hvis ikke - print feilmelding og send tilbake til start av loop "Coordinates should be from 1 to 3!"
// Sjekke om cellen er tatt
    // TODO: Hvis ikke - print feilmelding og send tilbake til start av loop "This cell is occupied! Choose another one!"
// ---

// Oppdater grid med nytt trekk
// Print den oppdaterte griden
}