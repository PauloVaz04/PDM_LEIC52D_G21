package isel.dei.pdm.demos.demo8puzzle.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import isel.dei.pdm.demos.demo8puzzle.core.Puzzle
import isel.dei.pdm.demos.demo8puzzle.core.Tile
import isel.dei.pdm.demos.demo8puzzle.ui.theme.Demo8PuzzleTheme

const val START_BUTTON_TAG = "StartButton"
const val RESET_BUTTON_TAG = "ResetButton"
const val SOLVE_BUTTON_TAG = "SolveButton"

@Composable
fun PuzzleScreen(viewModel: PuzzleScreenViewModel) {
    PuzzleScreenContent(
        state = viewModel.state,
        onTileClicked = { viewModel.moveTile(it) },
        onStart = { viewModel.start() },
        onReset = { viewModel.reset() },
        onSolve = { viewModel.solve() }
    )
}

@Composable
private fun PuzzleScreenContent(
    state: PuzzleScreenState,
    onTileClicked: (Tile) -> Unit,
    onStart: () -> Unit,
    onReset: () -> Unit,
    onSolve: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        PuzzleBoard(
            puzzle = state.puzzle,
            onTileClicked = onTileClicked
        )
        Spacer(modifier = Modifier.height(32.dp))
        when (state) {
            is PuzzleScreenState.Idle -> {
                Button(
                    onClick = onStart,
                    modifier = Modifier.testTag(START_BUTTON_TAG)
                ) {
                    Text(text = "Start", fontSize = 24.sp)
                }
            }
            is PuzzleScreenState.Solving -> {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Button(
                        onClick = onReset,
                        modifier = Modifier.testTag(RESET_BUTTON_TAG)
                    ) {
                        Text(text = "Reset", fontSize = 24.sp)
                    }
                    Button(
                        onClick = onSolve,
                        modifier = Modifier.testTag(SOLVE_BUTTON_TAG)
                    ) {
                        Text(text = "Solve", fontSize = 24.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuzzleScreenPreviewIdle() {
    Demo8PuzzleTheme {
        PuzzleScreenContent(
            state = PuzzleScreenState.Idle(Puzzle(1, 2, 3, 4, 5, 6, 7, 8, 0)),
            onTileClicked = { },
            onStart = { },
            onReset = { },
            onSolve = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PuzzleScreenPreviewSolving() {
    Demo8PuzzleTheme {
        PuzzleScreenContent(
            state = PuzzleScreenState.Solving(Puzzle(1, 2, 3, 4, 5, 6, 7, 8, 0)),
            onTileClicked = { },
            onStart = { },
            onReset = { },
            onSolve = { }
        )
    }
}
