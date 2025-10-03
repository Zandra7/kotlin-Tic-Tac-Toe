package org.example

class Brett(val brettTilstand: String) {
     val brettTilstand2dList = mutableListOf(
        mutableListOf(brettTilstand[0], brettTilstand[1], brettTilstand[2]),   //[0]
        mutableListOf(brettTilstand[3], brettTilstand[4], brettTilstand[5]),   //[1]
        mutableListOf(brettTilstand[6], brettTilstand[7], brettTilstand[8])    //[2]
    )

    fun printBrett() {
        println(
            """
        ---------
        | ${brettTilstand2dList[0][0]} ${brettTilstand2dList[0][1]} ${brettTilstand2dList[0][2]} |
        | ${brettTilstand2dList[1][0]} ${brettTilstand2dList[1][1]} ${brettTilstand2dList[1][2]} |
        | ${brettTilstand2dList[2][0]} ${brettTilstand2dList[2][1]} ${brettTilstand2dList[2][2]} |
        ---------
    """.trimIndent()
        )
    }

    fun erPosisjonLedig(yKoordinat: Int, xKoordinat: Int): ValideringsResultat {
        val celle = brettTilstand2dList[yKoordinat - 1][xKoordinat - 1]
        if (celle != SpillSymboler.LEDIG_POSISJON.tegn) {
            return ValideringsResultat(false, yKoordinat, xKoordinat, "This cell is occupied! Choose another one!")
        }
        return ValideringsResultat(true, yKoordinat, xKoordinat)
    }

    fun oppdaterBrett(yKoordinat: Int, xKoordinat: Int, spiller: Char) {
        brettTilstand2dList[yKoordinat - 1][xKoordinat - 1] = spiller
        printBrett()
    }
}
