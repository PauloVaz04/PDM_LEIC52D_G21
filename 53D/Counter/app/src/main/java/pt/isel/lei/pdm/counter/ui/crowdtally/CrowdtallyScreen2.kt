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
import kotlinx.coroutines.newSingleThreadContext
import pt.isel.lei.pdm.counter.domain.CrowdTallyInfo
import pt.isel.lei.pdm.counter.domain.changeMax
import pt.isel.lei.pdm.counter.domain.decrement
import pt.isel.lei.pdm.counter.domain.increment
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme

sealed interface CrowdTallyScreenViewState {
    data class Editor(val info: CrowdTallyInfo, val errorMsg: String = "") :
        CrowdTallyScreenViewState

    data class Counting(val info: CrowdTallyInfo) : CrowdTallyScreenViewState

}

@Composable
fun CrowdTallyScreen2() {

    var screenState: CrowdTallyScreenViewState by
    remember {
        mutableStateOf(
            CrowdTallyScreenViewState.Counting(
                CrowdTallyInfo(0, 10)
            )
        )
    }

    CounterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {

                when (val curr = screenState) {
                    is CrowdTallyScreenViewState.Counting -> {

                        Box(modifier = Modifier.fillMaxSize()) {
                            CrowdTallyView(
                                state = curr.info,
                                increment = {
                                    screenState = CrowdTallyScreenViewState.Counting(
                                        curr.info.increment()
                                    )
                                    Log.d("CrowdTallyScreen", "Increment ${curr.info.counter}")
                                },
                                decrement = {
                                    screenState = CrowdTallyScreenViewState.Counting(
                                        curr.info.decrement()
                                    )
                                    Log.d("CrowdTallyScreen", "Decrement ${curr.info.counter}")
                                }
                            )
                            Button(
                                onClick = {
                                    screenState = CrowdTallyScreenViewState.Editor(
                                        curr.info
                                    )
                                },
                                modifier = Modifier.align(Alignment.TopEnd)
                            ) {
                                Text("Edit")
                            }
                        }
                    }

                    is CrowdTallyScreenViewState.Editor -> {
                        Box()
                        {
                            CrowdTallyMaxEditor(
                                arg = curr.info,
                                onNewMax = {
                                    try {

                                        val newState = curr.info.changeMax(it)
                                        screenState = CrowdTallyScreenViewState.Counting(newState)
                                    } catch (e: Exception) {
                                        screenState = CrowdTallyScreenViewState.Editor(
                                            curr.info,
                                            e.toString()
                                        )
                                        return@CrowdTallyMaxEditor
                                    }
                                }
                            )
                            if (curr.errorMsg.isNotEmpty())
                                Text(text = curr.errorMsg, color = Color.Red)
                        }
                    }
                }


            }
        }
    }
}

