package com.example.wheeloffortune.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wheeloffortune.Destination
import com.example.wheeloffortune.TheWelcomeWheel

@Composable
fun WelcomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Card() {
        Column {
            Title2(title = "Welcome to: Wheel of Fortune")
            Spacer(modifier = Modifier.height(50.dp))
            TheWelcomeWheel()
            Spacer(modifier = Modifier.height(50.dp))
            StartButton(navController = navController, "Start Game")
        }
    }
}

@Composable
fun Title2(title: String) {
    Text(
        text = title,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopCenter)
    )
}
@Composable
fun StartButton(navController: NavHostController, output: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate(Destination.screen2.route)
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
