package isel.dei.pdm.demos.demo8puzzle.core

/**
 * Represents a tile in the 8-puzzle.
 * Tiles have values between 1 and 8.
 */
@JvmInline
value class Tile(val value: Int) {
    init {
        require(value in 1..8) { "Tile value must be between 1 and 8" }
    }

    override fun toString(): String = value.toString()
}
