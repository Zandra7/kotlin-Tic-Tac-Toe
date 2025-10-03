package org.example

import kotlin.math.abs

enum class SpillSymboler(val tegn: Char) {
    X('X'),
    O('O'),
    LEDIG_POSISJON('_')
}

const val TRE_X = "XXX"
const val TRE_O = "OOO"

enum class SpillResultat(val resultat: String) {
    UMULIG("Impossible"),
    SPILL_IKKE_FULLFØRT("Game not finished"),
    UAVGJORT("Draw"),
    X_VINNER("X wins"),
    O_VINNER("O wins"),
    FEILTILSTAND("Error")
}

class Spill(val brett: Brett) {
    fun beregnSpillResultat(): SpillResultat {
        val brettTilstand2dList = brett.brettTilstand2dList
        val vinnerKombinasjoner = listOf(
            listOf(brettTilstand2dList[0][0], brettTilstand2dList[0][1], brettTilstand2dList[0][2]),
            listOf(brettTilstand2dList[1][0], brettTilstand2dList[1][1], brettTilstand2dList[1][2]),
            listOf(brettTilstand2dList[2][0], brettTilstand2dList[2][1], brettTilstand2dList[2][2]),
            listOf(brettTilstand2dList[0][0], brettTilstand2dList[1][0], brettTilstand2dList[2][0]),
            listOf(brettTilstand2dList[0][1], brettTilstand2dList[1][1], brettTilstand2dList[2][1]),
            listOf(brettTilstand2dList[0][2], brettTilstand2dList[1][2], brettTilstand2dList[2][2]),
            listOf(brettTilstand2dList[0][0], brettTilstand2dList[1][1], brettTilstand2dList[2][2]),
            listOf(brettTilstand2dList[2][0], brettTilstand2dList[1][1], brettTilstand2dList[0][2]),
        )

        var harXTrePåRad = false
        var harOTrePåRad = false

        // TODO: Flytte til Brett.kt
        val harLedigePosisjoner = brettTilstand.contains(SpillSymboler.LEDIG_POSISJON.tegn)
        val antallX = brettTilstand.count { it == SpillSymboler.X.tegn }
        val antallO = brettTilstand.count { it == SpillSymboler.O.tegn }
        val harForMangeAvSymbol = abs(antallX - antallO) >= 2

        for (verdierIVinnerposisjoner in vinnerKombinasjoner) {
            val vinnerPosisjonerString = verdierIVinnerposisjoner.joinToString("")
            if (vinnerPosisjonerString == TRE_X) {
                harXTrePåRad = true
            } else if (vinnerPosisjonerString == TRE_O) {
                harOTrePåRad = true
            }
        }

        val resultat = when {
            harForMangeAvSymbol || (harXTrePåRad && harOTrePåRad) -> SpillResultat.UMULIG
            !harXTrePåRad && !harOTrePåRad && harLedigePosisjoner -> SpillResultat.SPILL_IKKE_FULLFØRT
            !harXTrePåRad && !harOTrePåRad -> SpillResultat.UAVGJORT
            harXTrePåRad -> SpillResultat.X_VINNER
            harOTrePåRad -> SpillResultat.O_VINNER
            else -> SpillResultat.FEILTILSTAND
        }
        return resultat
    }

    // TODO: Vi vil ikke sende inn boardState som string eller optional
    fun validerTrekk(trekk: String, brettTilstand: String?): ValideringsResultat {
        val trekkArray = trekk.split(" ")
        val yKoordinat = trekkArray[0].toIntOrNull()
        val xKoordinat = trekkArray[1].toIntOrNull()
        if (yKoordinat == null || xKoordinat == null) {
            return ValideringsResultat(false, -1, -1,"You should enter numbers!")
        }
        if (yKoordinat !in 1..3 || xKoordinat !in 1..3) {
            return ValideringsResultat(false, yKoordinat, xKoordinat, "Coordinates should be from 1 to 3!")
        }
        val erPosisjonLedig = brett.erPosisjonLedig(yKoordinat, xKoordinat)

        return erPosisjonLedig
    }

    fun spill() {
        var brettTilstand = brett.brettTilstand
        var spillResultat = beregnSpillResultat(brettTilstand)
        var xSinTur = true
        do {
            var erGyldig = false
            do {
                val trekk = readln() // 1 2
                val validerTrekkResultat = validerTrekk(trekk, brettTilstand)
                erGyldig = validerTrekkResultat.erGyldig
                if (!validerTrekkResultat.erGyldig) {
                    println(validerTrekkResultat.feilMelding)
                } else {
                    println("Ting funker")
                    val spillerBrikke = if (xSinTur) {'X'} else { 'O' }
                    brett.oppdaterBrett(validerTrekkResultat.yKoordinat, validerTrekkResultat.xKoordinat, spillerBrikke)
                    xSinTur = !xSinTur
                }
            } while (!erGyldig)
            brettTilstand = brett.brettTilstand
            spillResultat = beregnSpillResultat(brettTilstand)

            println(spillResultat)
            println(brettTilstand)

        } while (spillResultat == SpillResultat.SPILL_IKKE_FULLFØRT)
        println("noe tekst")
    }
}

// Creates a game loop
//  where the program asks the user to enter the cell coordinates,
//  analyzes the move for correctness and
//  shows a grid with the changes if everything is okay.


data class ValideringsResultat(
    val erGyldig: Boolean,
    val yKoordinat: Int, // -1 betyr ugyldig
    val xKoordinat: Int, // -1 betyr ugyldig
    val feilMelding: String? = null
)