package com.sylvinatests.jetpackkcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sylvinatests.jetpackkcomposeinstagram.ui.login.LoginScreen
import com.sylvinatests.jetpackkcomposeinstagram.ui.login.LoginViewModel
import com.sylvinatests.jetpackkcomposeinstagram.ui.theme.JetpackkComposeInstagramTheme
import com.sylvinatests.jetpackkcomposeinstagram.ui.tweet.BodyTweet
import com.sylvinatests.jetpackkcomposeinstagram.ui.tweet.MyScreenTweet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackkComposeInstagramTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White
                ) { innerPadding ->
                    LoginScreen(Modifier.padding(innerPadding), loginViewModel)
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
    JetpackkComposeInstagramTheme {
        Greeting("Android")
    }
}