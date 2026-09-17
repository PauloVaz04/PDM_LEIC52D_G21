package pt.isel.lei.pdm.counter.ui.greeting

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.isel.lei.pdm.counter.ui.theme.CounterTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier.Companion) {
    Box()
    {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Red)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Hellos $name!",
                modifier = modifier,
                fontSize = 30.sp
            )

            Button(
                modifier = Modifier.padding(12.dp),
                onClick = {
                    Log.d("Button", "onClick")
                }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Click")
                    Text(
                        text = "Me",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        Greeting("Android")
    }
}