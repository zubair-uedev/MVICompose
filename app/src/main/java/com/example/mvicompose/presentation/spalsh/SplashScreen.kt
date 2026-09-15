package com.example.mvicompose.presentation.spalsh

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvicompose.ui.theme.Blue40

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(goToSplash = {})
}

@Composable
fun SplashScreen(goToSplash: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = { goToSplash() },
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 20.dp, end = 10.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Blue40)

            ) {
                Text(
                    text = "Go to Splash",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}