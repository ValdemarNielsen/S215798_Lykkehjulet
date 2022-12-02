package com.example.wheeloffortune

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.wheeloffortune.ViewModel.LykkehjulViewModel
import com.example.wheeloffortune.gameData.GameData1
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun getWord() {
        val string = GameData1.GuessWordsandCategories()
        var counter = 0
        while (counter < 100) {
            string.ThemeAndWord()
            // println("The word is: " + string.correctWord)
            //  println("The theme is " + string.correctTheme)
            counter++
        }
    }

    @Test
    fun viewModelNewGameTest() {
        var viewModel = LykkehjulViewModel()
        viewModel.CheckTheLetter('a')
        viewModel.CheckTheLetter('b')
        viewModel.CheckTheLetter('a')
        viewModel.CheckTheLetter('c')
        viewModel.CheckTheLetter('d')
        viewModel.CheckTheLetter('e')
        viewModel.CheckTheLetter('f')
        viewModel.CheckTheLetter('g')
        viewModel.CheckTheLetter('h')
        viewModel.CheckTheLetter('i')
        viewModel.CheckTheLetter('j')
        viewModel.CheckTheLetter('k')
        viewModel.CheckTheLetter('l')
        viewModel.CheckTheLetter('m')
        viewModel.CheckTheLetter('n')
        println("List has length Should by more than 1:   " + viewModel.currentList())
        viewModel.newGame()
        println("List has length, should be 1 :   " + viewModel.currentList())
        assertEquals(1, viewModel.currentList())
        viewModel.CheckTheLetter('q')
        println("List has length, should be 2 " + viewModel.currentList())
        assertEquals(2, viewModel.currentList())


    }
    /*  @Test
      fun getLetter() {
          val string = GameData1.CheckIfWordIsCorrect()
          var counter = 0
          while (counter < 100) {
      string.CheckTheLetter("godmorgen")
              println(string.)
              counter++
          }

      } */
    // var string: String =GameData1.GuessWordsandCategories().correctTheme
}
