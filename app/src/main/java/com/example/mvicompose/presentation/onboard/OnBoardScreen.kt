package com.example.mvicompose.presentation.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvicompose.R
import com.example.mvicompose.ui.theme.Blue40

@Preview(showBackground = true)
@Composable
fun OnBoardScreenPreview() {
    OnBoardScreen(goToDashBoard = {})
}

@Composable
fun OnBoardScreen(goToDashBoard: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_android_img),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Column() {
                Button(
                    onClick = {
                        goToDashBoard()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            bottom = 10.dp,
                            start = 15.dp,
                            end = 15.dp
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = Blue40)

                ) {
                    Text(
                        text = "Go to DashBoard",
                        modifier = Modifier.padding(15.dp)
                    )
                }
            }
        }
    }
}