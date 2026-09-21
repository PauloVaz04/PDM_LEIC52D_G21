package pt.isel.lei.pdm.counter.ui.crowdtally

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pt.isel.lei.pdm.counter.domain.CrowdTallyInfo
import pt.isel.lei.pdm.counter.domain.changeMax
import pt.isel.lei.pdm.counter.domain.decrement
import pt.isel.lei.pdm.counter.domain.increment
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme


@Composable
fun CrowdTallyScreen() {
    var state by remember { mutableStateOf(CrowdTallyInfo(0, 10)) }
    var isEdit by remember { mutableStateOf(false) }
    var errorMsg by remember { mutableStateOf("") }

    CounterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                if (isEdit) {
                    Box()
                    {
                        CrowdTallyMaxEditor(
                            arg = state,
                            onNewMax = {
                                try {
                                    state = state.changeMax(it)

                                } catch (e: Exception) {
                                    errorMsg = e.toString()
                                    return@CrowdTallyMaxEditor
                                }
                                isEdit = false
                                errorMsg = ""
                            }
                        )
                        if (errorMsg.isNotEmpty())
                            Text(text = errorMsg, color = Color.Red)
                    }

                } else {
                    Box(modifier = Modifier.fillMaxSize()) {
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
                        Button(
                            onClick = {
                                isEdit = true
                            },
                            modifier = Modifier.align(Alignment.TopEnd)
                        ) {
                            Text("Edit")
                        }
                    }
                }


            }
        }
    }
}

