package org.example

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SpillTest {

    @Test
    fun `when boardState XXXOO__O_ expect X wins`() {
        val brettTilstand = "XXXOO__O_"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.X_VINNER, faktiskResultat)
    }

    @Test
    fun `when boardState XOXOXOXXO expect X wins`() {
        val brettTilstand = "XOXOXOXXO"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.X_VINNER, faktiskResultat)
    }

    @Test
    fun `when boardState XOOOXOXXO expect O wins`() {
        val brettTilstand = "XOOOXOXXO"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.O_VINNER, faktiskResultat)
    }

    @Test
    fun `when boardState XOXOOXXXO expect Draw`() {
        val brettTilstand = "XOXOOXXXO"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.UAVGJORT, faktiskResultat)
    }

    @Test
    fun `when boardState XO_OOX_X_ expect Game not finished`() {
        val brettTilstand = "XO_OOX_X_"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.SPILL_IKKE_FULLFØRT, faktiskResultat)
    }

    @Test
    fun `when boardState XO_XO_XOX expect Impossible`() {
        val brettTilstand = "XO_XO_XOX"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.UMULIG, faktiskResultat)
    }

    @Test
    fun `when boardState _O_X__X_X expect Impossible`() {
        val brettTilstand = "_O_X__X_X"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.UMULIG, faktiskResultat)
    }

    @Test
    fun `when boardState _OOOO_X_X expect Impossible`() {
        val brettTilstand = "_OOOO_X_X"
        val brett = Brett(brettTilstand)
        val spill = Spill(brett)
        val faktiskResultat = spill.beregnSpillResultat(brettTilstand)
        Assertions.assertEquals(SpillResultat.UMULIG, faktiskResultat)
    }

    /*
    @Test
    fun `when move 1 3 expect isValid true`(){
        val spill = Spill()
        val validationResult = spill.validerTrekk("1 3")
        Assertions.assertTrue(validationResult.isValid)
    }

    @Test
    fun `when move a b expect error message 'You should enter numbers!'`() {
        val spill = Spill()
        val validationResult = spill.validerTrekk("a b")
        Assertions.assertEquals("You should enter numbers!", validationResult.message)
    }

    @Test
    fun `when move 0 4 expect error message 'Coordinates should be from 1 to 3!'`(){
        val spill = Spill()
        val validationResult = spill.validerTrekk("0 4")
        Assertions.assertEquals("Coordinates should be from 1 to 3!", validationResult.message)
    }
    */
}