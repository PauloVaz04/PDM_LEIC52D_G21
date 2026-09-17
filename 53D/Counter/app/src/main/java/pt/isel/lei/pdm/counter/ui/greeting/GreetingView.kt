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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GreetingView(name: String, modifier: Modifier = Modifier) {

    Box()
    {
        Row(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(Color.Red)
                .align(Alignment.Center)
        ) { }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Hello $name!",
                modifier = modifier.padding(12.dp),
                fontSize = 30.sp
            )

            Button(
                onClick = {
                    Log.d("Button", "Click")
                }) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Click",
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Me",
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
