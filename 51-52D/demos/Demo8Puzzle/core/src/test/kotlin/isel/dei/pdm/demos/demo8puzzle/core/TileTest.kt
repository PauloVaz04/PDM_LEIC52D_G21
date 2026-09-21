package isel.dei.pdm.demos.demo8puzzle.core

import org.junit.Test
import org.junit.Assert.assertEquals

class TileTest {
    @Test
    fun `Tile value must be between 1 and 8`() {
        assertEquals(1, Tile(1).value)
        assertEquals(8, Tile(8).value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Tile value cannot be 0`() {
        Tile(0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Tile value cannot be 9`() {
        Tile(9)
    }
}
