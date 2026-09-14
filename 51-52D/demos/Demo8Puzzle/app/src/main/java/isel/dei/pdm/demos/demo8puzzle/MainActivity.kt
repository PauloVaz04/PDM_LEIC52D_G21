package isel.dei.pdm.demos.demo8puzzle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import isel.dei.pdm.demos.demo8puzzle.ui.PuzzleScreen
import isel.dei.pdm.demos.demo8puzzle.ui.theme.Demo8PuzzleTheme

const val APP_TAG = "Demo8PuzzleApp"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(APP_TAG, "onCreate()")
        enableEdgeToEdge()
        setContent {
            Demo8PuzzleTheme {
                PuzzleScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(APP_TAG, "onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.v(APP_TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(APP_TAG, "onDestroy()")
    }
}