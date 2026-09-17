package pt.isel.lei.pdm.counter.ui.counter

import android.annotation.SuppressLint
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
import pt.isel.lei.pdm.counter.domain.CounterModel
import pt.isel.lei.pdm.counter.domain.increment
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme

@Composable
fun CounterScreen() {
    var counter by mutableStateOf(CounterModel(123))

    CounterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column() {

                CounterView(
                    counter = counter,
                    onIncrement = {
                        counter = counter.increment()
                        Log.d("OnIncrement", "Counter ${counter.count}")
                    },
                    modifier = Modifier.padding(innerPadding)
                )
                /*
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
            }

        }
    }
}