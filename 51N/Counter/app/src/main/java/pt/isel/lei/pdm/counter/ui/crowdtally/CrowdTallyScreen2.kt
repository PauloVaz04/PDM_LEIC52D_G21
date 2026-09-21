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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import pt.isel.lei.pdm.counter.domain.CrowdTallyInfo
import pt.isel.lei.pdm.counter.domain.changeCapacity
import pt.isel.lei.pdm.counter.domain.decrement
import pt.isel.lei.pdm.counter.domain.increment
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme


sealed interface CrowdTallyScreenViewState {
    data class Configuration(val info: CrowdTallyInfo) : CrowdTallyScreenViewState
    data class Counting(val info: CrowdTallyInfo) : CrowdTallyScreenViewState
    data class ConfigurationError(val error: Exception, val info: CrowdTallyInfo) :
        CrowdTallyScreenViewState
    //data object Error : CrowdTallyScreenViewState
}

@Composable
fun CrowdTallyScreen2() {
    Log.d("CrowdTallyScreen", "recomposition")

    var screenState: CrowdTallyScreenViewState by remember {
        mutableStateOf(
            CrowdTallyScreenViewState.Counting(CrowdTallyInfo(0, 10))
        )
    }

    CounterTheme() {
        Log.d("CounterTheme", "Recomposition")
        Scaffold() { innerPadding ->
            Log.d("Scaffold", "Recomposition")
            when (val state = screenState) {
                is CrowdTallyScreenViewState.Configuration -> {

                    CrowdTallyMaxConfiguratorContent(
                        state.info,
                        { newCapacity ->
                            try {
                                screenState = CrowdTallyScreenViewState.Counting(
                                    state.info.changeCapacity(newCapacity)
                                )
                            } catch (e: Exception) {
                                screenState = CrowdTallyScreenViewState.ConfigurationError(
                                    e, state.info
                                )
                            }

                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                is CrowdTallyScreenViewState.Counting -> {
                    Box()
                    {

                        CrowdTallyContent(
                            state = state.info,
                            increment = {
                                screenState = CrowdTallyScreenViewState.Counting(
                                    state.info.increment()
                                )
                            },
                            decrement = {
                                screenState = CrowdTallyScreenViewState.Counting(
                                    state.info.decrement()
                                )
                            },
                            modifier = Modifier.padding(innerPadding)
                        )

                        Button(
                            onClick = {
                                screenState = CrowdTallyScreenViewState.Configuration(
                                    state.info
                                )
                            },
                            modifier = Modifier.align(Alignment.TopEnd)
                        ) {
                            Text("Edit")
                        }
                    }

                }

                is CrowdTallyScreenViewState.ConfigurationError -> {

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = state.error.toString(),
                            color = Color.Red,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                        )
                        Button(onClick = {
                            screenState = CrowdTallyScreenViewState.Configuration(
                                state.info
                            )
                        }) {
                            Text("Dismiss")
                        }
                    }

                }
            }


        }
    }
}

