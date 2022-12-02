package com.example.wheeloffortune.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wheeloffortune.Destination
import com.example.wheeloffortune.R
import com.example.wheeloffortune.ThePlayWheel
import com.example.wheeloffortune.ViewModel.LykkehjulViewModel

@Composable
fun PlayScreen(
    navController: NavHostController,
    viewModel: LykkehjulViewModel
) {
    val state by viewModel.interfaceTilstand.collectAsState()

    Card() {
        Column {
            Title(title = "Wheel of Fortune!")
         //   Text(text = state.word)
            restartButton(viewModel, navController)

            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Column() {
                    Row {

                        HealthImage()
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                            "Current = " + state.lives,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Row {
                        MoneyImage()
                        Text(
                            "Total = " + state.myMoney,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = "Theme = " + state.theme, fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Column(horizontalAlignment = Alignment.End) {

                    ThePlayWheel()
                    Spacer(modifier = Modifier.height(10.dp))
                    RollButton("Spin the wheel", viewModel)
                    Text(
                        "Current = " + state.spinMoney,
                        fontSize = 20.sp, fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Text(
                text = state.currentWord,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
            Keyboard(viewModel, navController)
        }
    }
}

@Composable
fun RollButton(output: String, viewModel: LykkehjulViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        Alignment.TopEnd
    ) {
        Button(
            onClick = {
                viewModel.spin()
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 200.dp, height = 70.dp)
        ) {
            Text(
                text = output,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp, color = Color.Black
            )
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 39.sp,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopCenter)
    )
}

@Composable
fun HealthImage(modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.healthremaining),
            contentDescription = null,
            modifier = Modifier
                .height(75.dp)
                .width(75.dp)
                .wrapContentSize(Alignment.TopStart)
        )
    }
}

@Composable
fun MoneyImage(modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.dollarsign),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .width(95.dp)
                .wrapContentSize(Alignment.TopStart)
        )
    }
}

@Composable
fun KeyboardButton(output: Char,viewModel: LykkehjulViewModel, navController: NavHostController, ) {

    Button(
        onClick = {
            viewModel.CheckTheLetter(output, navController)
            viewModel.maxMoney()
        },
        colors = ButtonDefaults.buttonColors(Color.Green),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .size(width = 45.dp, height = 45.dp)
    ) {
        Text(
            text = output.toString(),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp, color = Color.Black
        )
    }
}

@Composable
fun Keyboard(viewModel: LykkehjulViewModel, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            KeyboardButton(output = 'A', viewModel,navController)
            KeyboardButton(output = 'B', viewModel, navController)
            KeyboardButton(output = 'C', viewModel, navController)
            KeyboardButton(output = 'D', viewModel, navController)
            KeyboardButton(output = 'E', viewModel, navController)
            KeyboardButton(output = 'F', viewModel, navController)
            KeyboardButton(output = 'G', viewModel, navController)
            KeyboardButton(output = 'H', viewModel, navController)
            KeyboardButton(output = 'I', viewModel, navController)
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .width(1.dp)
            )
        }
        Row() {
            KeyboardButton(output = 'J', viewModel, navController)
            KeyboardButton(output = 'K', viewModel, navController)
            KeyboardButton(output = 'L', viewModel, navController)
            KeyboardButton(output = 'M', viewModel, navController)
            KeyboardButton(output = 'N', viewModel, navController)
            KeyboardButton(output = 'O', viewModel, navController)
            KeyboardButton(output = 'P', viewModel, navController)
            KeyboardButton(output = 'Q', viewModel, navController)
        }
        Row() {
            KeyboardButton(output = 'R', viewModel, navController)
            KeyboardButton(output = 'S', viewModel, navController)
            KeyboardButton(output = 'T', viewModel, navController)
            KeyboardButton(output = 'U', viewModel, navController)
            KeyboardButton(output = 'V', viewModel, navController)
            KeyboardButton(output = 'W', viewModel, navController)
            KeyboardButton(output = 'Y', viewModel, navController)
            KeyboardButton(output = 'Z', viewModel, navController)
        }
    }
}

/* currently restartButton cant restart the game,
 as "guessedLetters" will not reset. This i cant solve at the moment.
*/
@Composable
fun restartButton(viewModel: LykkehjulViewModel, navController: NavHostController) {
    Button(
        onClick = { viewModel.newGame()
            navController.navigate(Destination.screen1.route)},
        colors = ButtonDefaults.buttonColors(
            Color.Magenta
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .size(width = 110.dp, height = 50.dp)
    ) {
        Text(
            text = "Restart game",
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp, color = Color.Black
        )

    }
}