package com.example.wheeloffortune


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wheeloffortune.ViewModel.LykkehjulViewModel
import com.example.wheeloffortune.screens.LoseScreen
import com.example.wheeloffortune.screens.PlayScreen
import com.example.wheeloffortune.screens.WelcomeScreen
import com.example.wheeloffortune.screens.WinScreen

@Composable
fun NavigationAppHost(navController: NavHostController, viewModel: LykkehjulViewModel) {

    NavHost(navController = navController, startDestination = Destination.screen1.route) {
        composable(Destination.screen1.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Destination.screen2.route) {
            PlayScreen(navController = navController, viewModel)
        }
        composable(Destination.screen3.route) {
            LoseScreen(navController = navController, viewModel)
        }
        composable(Destination.screen4.route) {
            WinScreen(navController = navController, viewModel)
        }
    }

}
