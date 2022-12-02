package com.example.wheeloffortune.model

data class SpilTilstand(
    // is the word to be guessed
    var word: String = "",
    // Your lives.
    var lives: Int = 5,
    // overall money
    var myMoney: Int = 0,
    // curret money on the wheel
    var spinMoney: Int=0,
    // Points this round (combination of spinmoney and currentCorrectLetters
    var thisRoundPoints: String = "",
    // The correct amount of a given letter (eg. 2 of the same letter).
    var currentCorrectLetters: Int = 0,
    // The words theme
    var theme: String = "",
    // is the hidden word
    var currentWord: String = "",
    // is a list of the guessed words
    var guessedLetters: MutableList<String> = mutableListOf("")
)