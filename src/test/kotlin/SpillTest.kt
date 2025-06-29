import org.example.Spill
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpillTest {

    @Test
    fun `when trekk XXXOO__O_ expect X wins`() {
        val trekk = "XXXOO__O_"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("X wins", actualResult)
    }

    @Test
    fun `when trekk XOXOXOXXO expect X wins`() {
        val trekk = "XOXOXOXXO"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("X wins", actualResult)
    }

    @Test
    fun `when trekk XOOOXOXXO expect O wins`() {
        val trekk = "XOOOXOXXO"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("O wins", actualResult)
    }

    @Test
    fun `when trekk XOXOOXXXO expect Draw`() {
        val trekk = "XOXOOXXXO"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("Draw", actualResult)
    }

    @Test
    fun `when trekk XO_OOX_X_ expect Game not finished`() {
        val trekk = "XO_OOX_X_"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("Game not finished", actualResult)
    }

    @Test
    fun `when trekk XO_XO_XOX expect Impossible`() {
        val trekk = "XO_XO_XOX"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("Impossible", actualResult)
    }

    @Test
    fun `when trekk _O_X__X_X expect Impossible`() {
        val trekk = "_O_X__X_X"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("Impossible", actualResult)
    }

    @Test
    fun `when trekk _OOOO_X_X expect Impossible`() {
        val trekk = "_OOOO_X_X"
        val spill = Spill()
        val actualResult = spill.spillLogikk(trekk)
        assertEquals("Impossible", actualResult)
    }
}