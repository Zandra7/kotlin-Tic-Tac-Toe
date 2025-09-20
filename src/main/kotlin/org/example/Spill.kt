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
    fun beregnSpillResultat(brettTilstand: String): SpillResultat {
        val vinnerKombinasjoner = listOf(
            listOf(brettTilstand[0], brettTilstand[1], brettTilstand[2]),
            listOf(brettTilstand[3], brettTilstand[4], brettTilstand[5]),
            listOf(brettTilstand[6], brettTilstand[7], brettTilstand[8]),
            listOf(brettTilstand[0], brettTilstand[3], brettTilstand[6]),
            listOf(brettTilstand[1], brettTilstand[4], brettTilstand[7]),
            listOf(brettTilstand[2], brettTilstand[5], brettTilstand[8]),
            listOf(brettTilstand[0], brettTilstand[4], brettTilstand[8]),
            listOf(brettTilstand[2], brettTilstand[4], brettTilstand[6]),
        )

        var harXTrePåRad = false
        var harOTrePåRad = false

        // TODO: Kanskje flytte til Brett.kt
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
}

data class ValideringsResultat(
    val erGyldig: Boolean,
    val yKoordinat: Int, // -1 betyr ugyldig
    val xKoordinat: Int, // -1 betyr ugyldig
    val feilMelding: String? = null
)