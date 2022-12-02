package com.example.wheeloffortune.ViewModel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheeloffortune.Destination
import com.example.wheeloffortune.NavigationAppHost
import com.example.wheeloffortune.gameData.GameData1
import com.example.wheeloffortune.gameData.SpilTilstand
import com.example.wheeloffortune.gameData.correctTheme
import com.example.wheeloffortune.gameData.correctWord
import com.example.wheeloffortune.model.SpilTilstand
import com.example.wheeloffortune.screens.LoseScreen
import com.example.wheeloffortune.screens.restartButton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LykkehjulViewModel : ViewModel() {
    private val spilTilstand = MutableStateFlow(SpilTilstand())
    val interfaceTilstand: StateFlow<SpilTilstand> = spilTilstand.asStateFlow()
    val gameData1 = GameData1()


    init {
        newGame()
    }

    fun loseLive(navController: NavController) {
        val lives = spilTilstand.value.lives - 1
        if (lives == 0) {
           navController.navigate(Destination.screen3.route)
        }
        spilTilstand.update { t -> t.copy(lives = lives) }
    }


    fun maxMoney() {
        var myMaxMoney = GameData1.HealthRemaining().startHealth
        if (spilTilstand.value.spinMoney == 0) {
            myMaxMoney = 0
        } else {
            myMaxMoney =
                (spilTilstand.value.spinMoney * spilTilstand.value.currentCorrectLetters) + spilTilstand.value.myMoney
        }
        spilTilstand.update { t ->
            t.copy(
                myMoney = myMaxMoney
            )
        }
    }

    fun newGame() {
        var guessedLetters: MutableList<String> = mutableListOf("")
        spilTilstand.update { t ->
            t.copy(
                word = "",
                theme = "",
                currentWord = "",
                guessedLetters = guessedLetters,
                myMoney = 0,
                spinMoney = 0,
                lives = 5
            )
        }
        var word = GameData1.GuessWordsandCategories()
        var hiddenWord = ""
        word.ThemeAndWord()
        for (char in correctWord) {
            hiddenWord = hiddenWord.plus("—")
        }
        spilTilstand.update { t ->
            t.copy(
                word = correctWord,
                theme = correctTheme,
                currentWord = hiddenWord,
                guessedLetters = mutableListOf("")
            )
        }
    }

    fun currentList(): Int {
        return spilTilstand.value.guessedLetters.size
    }

    fun CheckTheLetter(letter: Char, navController: NavController) {
        SpilTilstand.guessedLetters.add(letter.toString())
        val correctWordChar = correctWord.uppercase().toCharArray()
        var amountCorrectLetter = 0
        for (i in 0..correctWordChar.size - 1) {
            if (correctWordChar[i] == letter) {
                amountCorrectLetter++
            }
        }
        if (amountCorrectLetter == 0) {
            loseLive(navController)
        }
        if (SpilTilstand.guessedLetters.size-1 == correctWordChar.size) {
            navController.navigate(Destination.screen4.route)
        }

        var hiddenWord = ""
        for (char in correctWord.uppercase()) {
            if (SpilTilstand.guessedLetters.contains(char.toString())) {
                hiddenWord = hiddenWord.plus(char)
            } else {
                hiddenWord = hiddenWord.plus("—")
            }
        }
        spilTilstand.update { t ->
            t.copy(
                word = correctWord,
                theme = correctTheme,
                currentWord = hiddenWord,
                currentCorrectLetters = amountCorrectLetter,
                guessedLetters = SpilTilstand.guessedLetters
            )
        }
    }

    fun spin() {
        val newMoney = GameData1.GamePoints().currentSpinPoint
        println("newMoney is: " + newMoney)
        spilTilstand.update { t ->
            t.copy(
                spinMoney = newMoney
            )
        }
    }


}