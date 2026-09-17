package pt.isel.lei.pdm.counter.ui.counter

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import pt.isel.lei.pdm.counter.domain.CounterInfo
import pt.isel.lei.pdm.counter.domain.increment
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme

@Composable
 fun CounterScreen() {
    var state by mutableStateOf(CounterInfo(123))
    CounterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            /*
                 Greeting(
                     name = "Android",
                     modifier = Modifier.padding(innerPadding)
                 )*/
            Column(modifier = Modifier.padding(innerPadding)) {
                CounterView(state, {
                    state = state.increment()
                    Log.d("test", "test")
                })
            }
        }
    }
}