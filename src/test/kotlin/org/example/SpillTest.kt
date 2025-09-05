package org.example

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SpillTest {

    @Test
    fun `when boardState XXXOO__O_ expect X wins`() {
        val boardState = "XXXOO__O_"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("X wins", actualResult)
    }

    @Test
    fun `when boardState XOXOXOXXO expect X wins`() {
        val boardState = "XOXOXOXXO"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("X wins", actualResult)
    }

    @Test
    fun `when boardState XOOOXOXXO expect O wins`() {
        val boardState = "XOOOXOXXO"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("O wins", actualResult)
    }

    @Test
    fun `when boardState XOXOOXXXO expect Draw`() {
        val boardState = "XOXOOXXXO"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("Draw", actualResult)
    }

    @Test
    fun `when boardState XO_OOX_X_ expect Game not finished`() {
        val boardState = "XO_OOX_X_"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("Game not finished", actualResult)
    }

    @Test
    fun `when boardState XO_XO_XOX expect Impossible`() {
        val boardState = "XO_XO_XOX"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("Impossible", actualResult)
    }

    @Test
    fun `when boardState _O_X__X_X expect Impossible`() {
        val boardState = "_O_X__X_X"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("Impossible", actualResult)
    }

    @Test
    fun `when boardState _OOOO_X_X expect Impossible`() {
        val boardState = "_OOOO_X_X"
        val spill = Spill()
        val actualResult = spill.spillLogikk(boardState)
        Assertions.assertEquals("Impossible", actualResult)
    }

    @Test
    fun `when move 1 3 expect isValid true`(){
        val spill = Spill()
        val validationResult = spill.isValidInput("1 3")
        Assertions.assertTrue(validationResult.isValid)
    }

    @Test
    fun `when move a b expect error message 'You should enter numbers!'`() {
        val spill = Spill()
        val validationResult = spill.isValidInput("a b")
        Assertions.assertEquals("You should enter numbers!", validationResult.message)
    }

    @Test
    fun `when move 0 4 expect error message 'Coordinates should be from 1 to 3!'`(){
        val spill = Spill()
        val validationResult = spill.isValidInput("0 4")
        Assertions.assertEquals("Coordinates should be from 1 to 3!", validationResult.message)
    }
}