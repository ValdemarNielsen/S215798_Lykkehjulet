package com.example.wheeloffortune.gameData

import com.example.wheeloffortune.model.SpilTilstand
import java.util.*
import kotlin.random.Random
import kotlin.system.exitProcess

val SpilTilstand = SpilTilstand()
val seed = Calendar.getInstance().timeInMillis
var random = Random(seed)
var correctTheme = ""
var correctWord = ""


class GameData1 {
    var points: GameData1.GamePoints = GamePoints()
    var health: GameData1.HealthRemaining = HealthRemaining()

    class HealthRemaining {

        val startHealth = 5
            }

    class GamePoints {
        val spinPoints = listOf(100, 300, 500, 600, 800, 1000, 1500, 0)
        var currentSpinPoint = spinPoints.random(random = random)
}

    class GuessWordsandCategories {
        val animals = listOf(
            "Horse", "Giraf",
            "Zebra", "Swan", "Snake",
            "Ostrich", "Mouse", "Panther"
        )
        val brands = listOf(
            "Huawei", "Volkswagen",
            "Ford", "Audi", "Lacoste",
            "Puma", "Nike", "Rolex"
        )
        val food = listOf(
            "Cake", "Fries",
            "Cucumber", "Rice", "Hazelnut",
            "Fruit", "", "Bacon"
        )
        val sport = listOf(
            "Walking", "Jumping",
            "Gymnastic", "Surfing", "Hockey",
            "Handball", "Badminton", "Jumping"
        )
        fun ThemeAndWord() {

            val result = (1..4).random(random = random)
            val ranWord = (0..7).random(random = random)

            when (result) {
                1 -> {
                    correctTheme = "Animals"
                    correctWord = animals[ranWord]
                }
                2 -> {
                    correctTheme = "Brands"
                    correctWord = brands[ranWord]
                }
                3 -> {
                    correctTheme = "Food"
                    correctWord = food[ranWord]
                }
                else -> {
                    correctTheme = "Sports"
                    correctWord = sport[ranWord]
                }
            }
        }

    }
}

