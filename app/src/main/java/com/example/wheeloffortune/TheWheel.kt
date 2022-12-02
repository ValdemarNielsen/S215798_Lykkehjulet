package com.example.wheeloffortune


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TheWelcomeWheel(modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.lykkehjuletwheel),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
              //  .fillMaxHeight()
                .wrapContentSize(Alignment.TopCenter)
        )
    }
}

@Composable
fun ThePlayWheel(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.size(width = 1000.dp, height = 200.dp)) {
        Image(
            painter = painterResource(id = R.drawable.lykkehjuletwheel),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                //  .fillMaxHeight()
                .wrapContentSize(Alignment.TopEnd)
        )
    }
}