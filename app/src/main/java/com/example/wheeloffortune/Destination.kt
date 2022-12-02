package com.example.wheeloffortune

sealed class Destination(val route: String) {
    object screen1: Destination("welcomescreen")
    object screen2: Destination("playscreen")
    object screen3: Destination("LoseScreen")
    object screen4: Destination("WinScreen")

}