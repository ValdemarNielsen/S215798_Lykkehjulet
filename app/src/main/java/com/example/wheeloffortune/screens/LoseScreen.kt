package com.example.wheeloffortune.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.wheeloffortune.MainActivity
import com.example.wheeloffortune.R
import com.example.wheeloffortune.ViewModel.LykkehjulViewModel

@Composable
fun LoseScreen(navController: NavHostController,viewModel: LykkehjulViewModel) {
    val state by viewModel.interfaceTilstand.collectAsState()
    Box(modifier = Modifier.fillMaxHeight().fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.youlose),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .wrapContentSize(Alignment.Center)
        )
        restartButton(viewModel, navController)
    }
}
