package com.msgulberk.bootcamp_one.ui_

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msgulberk.bootcamp_one.R
import com.msgulberk.bootcamp_one.ui.theme.Bootcamp_oneTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("BTK_LOG", "onCreate")

    }

    override fun onStart() {
        Log.e("BTK_LOG", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("BTK_LOG", "onResume")
        super.onResume()
    }

    override fun onStop() {
        Log.e("BTK_LOG", "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.e("BTK_LOG", "onRestart")
        super.onRestart()
    }

    override fun onPause() {
        Log.e("BTK_LOG", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.e("BTK_LOG", "onDestroy")
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bootcamp_oneTheme {
        Greeting("Android")
    }
}