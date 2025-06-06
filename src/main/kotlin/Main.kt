package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val c = readln()
    println("""
        ---------
        | ${c[0]} ${c[1]} ${c[2]} |
        | ${c[3]} ${c[4]} ${c[5]} |
        | ${c[6]} ${c[7]} ${c[8]} |
        ---------
    """.trimIndent())

    val vinnerPosisjoner = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6),
    )

    for (mainIndex in vinnerPosisjoner) {
        var isXWinner = true
        var isOWinner = true
        for (index in mainIndex) {
            // 0 1 2
            // XXXOO__O_
            if (c[index] == 'X' && isXWinner) {
                isXWinner = true
                isOWinner = false
            } else if (c[index] == 'O' && isOWinner) {
                isOWinner = true
                isXWinner = false
            } else {
                isOWinner = false
                isXWinner = false
            }
        }
        if (isXWinner) {
            println("X wins")
        } else if (isOWinner) {
            println("O wins")
        }
    }

    // vinnerindex: 0 1 2, 3 4 5, 6 7 8, 0 3 6, 1 4 7, 2 5 8, 0 4 8, 2 4 6
    // lagre vinnerindex i multidimensjonell liste
    // loope igjennom hver liste i lista
    // sjekke at input i disse indexene er kun X/O

}