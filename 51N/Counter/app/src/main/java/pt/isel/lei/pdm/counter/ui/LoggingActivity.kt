package pt.isel.lei.pdm.counter.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

open class LoggingActivity : ComponentActivity() {
    val className
        get() = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(className, "onCreate")
    }

    override fun onStart() {
        Log.d(className, "onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.d(className, "onStop")
        super.onStop()

    }

    override fun onResume() {
        Log.d(className, "onResume")
        super.onResume()
    }

    override fun onRestart() {
        Log.d(className, "onRestart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(className, "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(className, "onDestroy")
        super.onDestroy()
    }

}