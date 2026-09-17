package pt.isel.lei.pdm.counter.ui.counter

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import pt.isel.lei.pdm.counter.domain.CounterInfo

@Composable
fun CounterView(
    number: CounterInfo,
    onIncrement: () -> Unit
) {
    Row() {
        Text(
            text = "${number.counter}",
            fontSize = 20.sp
        )
        Button(onClick = {
            Log.d("CounterViewButton", "Clicked")
            onIncrement()
        }) {
            Text("^")
        }
    }
}

@Preview
@Composable
fun CounterPreview(){
    CounterView(CounterInfo(12324)) { }
}


@Preview
@Composable
fun CounterPreview2(){
    CounterView(CounterInfo(122222223)) { }
}

@Preview(widthDp = 50)
@Composable
fun CounterPreview50px(){
    CounterView(CounterInfo(122222223)) { }
}