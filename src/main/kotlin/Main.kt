package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val c = readln()
    // val c: CharArray = input.toCharArray()
    print("""
        ---------
        | ${c[0]} ${c[1]} ${c[2]} |
        | ${c[3]} ${c[4]} ${c[5]} |
        | ${c[6]} ${c[7]} ${c[8]} |
        ---------
    """.trimIndent())
}