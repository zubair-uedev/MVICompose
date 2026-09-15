package com.example.mvicompose.presentation.onboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun OnBoardScreen(goToOnBoard:()-> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "OnBoarding")
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {goToOnBoard()}) {
                Text(text = "Go to OnBoarding")
            }
        }
    }
}