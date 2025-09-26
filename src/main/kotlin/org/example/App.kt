package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//13
//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
//	at java.base/java.util.Collections$SingletonList.get(Collections.java:5179)
//	at org.example.Spill.validerTrekk(Spill.kt:69)
//	at org.example.AppKt.main(App.kt:18)
//	at org.example.AppKt.main(App.kt)

fun main() {
    val brettTilstand = "_XXOO_OX_" // TODO: bytt tilbake til readln()
    val brett = Brett(brettTilstand)
    val spill = Spill(brett)
    brett.printBrett()
    spill.spill()


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