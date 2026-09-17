package isel.dei.pdm.demos.demo8puzzle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import isel.dei.pdm.demos.demo8puzzle.ui.theme.Demo8PuzzleTheme

@Composable
fun PuzzleTile(value: Int?) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp)
            .background(
                if (value != null) MaterialTheme.colorScheme.secondaryContainer
                else Color.Transparent
            )
            .border(
                1.dp,
                if (value != null) MaterialTheme.colorScheme.outline
                else Color.Transparent,
            ),
        contentAlignment = Alignment.Center
    ) {
        if (value != null) {
            Text(
                text = value.toString(),
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuzzleTilePreview() {
    Demo8PuzzleTheme {
        PuzzleTile(value = 5)
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyPuzzleTilePreview() {
    Demo8PuzzleTheme {
        PuzzleTile(value = null)
    }
}
