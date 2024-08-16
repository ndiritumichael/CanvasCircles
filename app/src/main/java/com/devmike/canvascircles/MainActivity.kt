package com.devmike.canvascircles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devmike.canvascircles.ui.theme.CanvasCirclesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanvasCirclesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var showLoginScreen by remember {
                        mutableStateOf(false)
                    }


                 if (showLoginScreen) {
                     LoginScreen(modifier = Modifier.padding(innerPadding)){
                         showLoginScreen = false
                     } }
                    else{

                     WelcomeScreen() {
                         showLoginScreen = true

                     }
                    }


                }
            }
        }
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
    CanvasCirclesTheme {
        Greeting("Android")
    }
}