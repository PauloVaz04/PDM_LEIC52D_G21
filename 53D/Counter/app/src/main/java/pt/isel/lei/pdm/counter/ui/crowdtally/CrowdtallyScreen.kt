package pt.isel.lei.pdm.counter.ui.crowdtally

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pt.isel.lei.pdm.counter.domain.CrowdTallyInfo
import pt.isel.lei.pdm.counter.domain.decrement
import pt.isel.lei.pdm.counter.domain.increment
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme


@Composable
fun CrowdTallyScreen() {
    var state by mutableStateOf(CrowdTallyInfo(0))
    CounterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                CrowdTallyView(
                    state = state,
                    increment = {
                        state = state.increment()
                        Log.d("CrowdTallyScreen", "Increment ${state.counter}")
                    },
                    decrement = {
                        state = state.decrement()
                        Log.d("CrowdTallyScreen", "Decrement ${state.counter}")
                    }
                )
            }
        }
    }
}

@Composable
fun CrowdTallyView(
    state: CrowdTallyInfo,
    increment: () -> Unit,
    decrement: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = decrement
        )
        {
            Text("\uD83D\uDC47")
        }

        Text(text = state.counter.toString())

        Button(
            onClick = increment
        )
        {
            Text("☝\uFE0F")
        }
    }
}