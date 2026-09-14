package isel.dei.pdm.demos.demo8puzzle.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import isel.dei.pdm.demos.demo8puzzle.ui.theme.Demo8PuzzleTheme

@Composable
fun PuzzleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        PuzzleBoard(
            tiles = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, null)
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { /* TODO */ }) {
            Text(text = "Start", fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuzzleScreenPreview() {
    Demo8PuzzleTheme {
        PuzzleScreen()
    }
}
