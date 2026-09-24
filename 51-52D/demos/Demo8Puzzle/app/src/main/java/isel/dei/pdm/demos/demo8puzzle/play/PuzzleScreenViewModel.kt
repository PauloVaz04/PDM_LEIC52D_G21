package isel.dei.pdm.demos.demo8puzzle.play

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import isel.dei.pdm.demos.demo8puzzle.APP_TAG
import isel.dei.pdm.demos.demo8puzzle.buildLLogTag
import isel.dei.pdm.demos.demo8puzzle.core.Puzzle
import isel.dei.pdm.demos.demo8puzzle.core.Tile

/**
 * The set of states that the puzzle screen can be in.
 */
sealed class PuzzleScreenState {
    abstract val puzzle: Puzzle
    data class Idle(override val puzzle: Puzzle) : PuzzleScreenState()
    data class Solving(override val puzzle: Puzzle) : PuzzleScreenState()
}

/**
 * The view model for the puzzle screen. It holds the screen's state and provides methods
 * to produce the admissible state transitions.
 */
class PuzzleScreenViewModel : ViewModel() {

    private val logTag = buildLLogTag(this::class.java.simpleName)

    init {
        Log.v(logTag, "init on ${hashCode()}")
    }

    var state by mutableStateOf<PuzzleScreenState>(
        PuzzleScreenState.Idle(Puzzle(1, 2, 3, 4, 5, 6, 7, 8, 0))
    )
        private set

    fun moveTile(tile: Tile) {
        val current = state
        if (current is PuzzleScreenState.Solving) {
            state = PuzzleScreenState.Solving(current.puzzle.move(tile))
        }
    }

    fun start() {
        val current = state
        if (current is PuzzleScreenState.Idle) {
            state = PuzzleScreenState.Solving(current.puzzle)
        }
    }

    fun reset() {
        val current = state
        if (current is PuzzleScreenState.Solving) {
            state = PuzzleScreenState.Idle(Puzzle(1, 2, 3, 4, 5, 6, 7, 8, 0))
        }
    }

    fun solve() {
        // Will be implemented later
        Log.v(APP_TAG, "PuzzleScreenViewModel.solve() - Not implemented yet")
    }

    override fun onCleared() {
        Log.v(APP_TAG, "PuzzleScreenViewModel.onCleared() on ${hashCode()}")
    }
}
