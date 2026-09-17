package isel.dei.pdm.demos.demo8puzzle.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import isel.dei.pdm.demos.demo8puzzle.ui.theme.Demo8PuzzleTheme

@Composable
fun PuzzleBoard(tiles: List<List<Int?>>) {
    Column(
        modifier = Modifier
            .border(2.dp, MaterialTheme.colorScheme.primary)
            .padding(4.dp),
    ) {
        tiles.forEach { row ->
            Row {
                row.forEach { tile ->
                    PuzzleTile(tile)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuzzleBoardPreview() {
    Demo8PuzzleTheme {
        PuzzleBoard(
            tiles = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, null)
            )
        )
    }
}
