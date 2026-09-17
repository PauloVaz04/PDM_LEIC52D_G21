package pt.isel.lei.pdm.counter.ui.counter

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.isel.lei.pdm.counter.domain.CounterModel

@Composable
fun CounterView(
    counter: CounterModel,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier.Companion
) {

    Row(modifier = modifier.fillMaxWidth()) {
        Log.d("CounterView", "Here")
        Text(text = "${counter.count}")
        Button(
            onClick = {
                Log.d("CounterView", "up button")
                onIncrement()
            },
        ) {

            Text("up")
        }
    }
}

@Composable
@Preview
fun CounterViewPreview() {
    CounterView(CounterModel(1234), {})
}

@Preview
@Composable
fun CounterViewPreview2() {
    CounterView(CounterModel(0), {})
}

@Preview(widthDp = 50)
@Composable
fun CounterViewPreview3() {
    CounterView(CounterModel(10), {})
}

