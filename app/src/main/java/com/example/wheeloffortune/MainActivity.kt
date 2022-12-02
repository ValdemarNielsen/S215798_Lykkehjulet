package com.example.wheeloffortune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.wheeloffortune.ViewModel.LykkehjulViewModel
import com.example.wheeloffortune.ui.theme.Teal200
import com.example.wheeloffortune.ui.theme.WheelOfFortuneTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            WheelOfFortuneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Teal200,

                ) {
                    val navController = rememberNavController()
                    val viewModel = LykkehjulViewModel()
                    NavigationAppHost(navController = navController,viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(modifier: Modifier = Modifier) {
    TheWelcomeWheel()
}