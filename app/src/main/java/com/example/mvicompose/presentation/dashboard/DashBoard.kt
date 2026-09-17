package com.example.mvicompose.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun DashBoardPreview() {
    DashBoard(onIntent = {})
}

@Composable
fun DashBoard(onIntent: (DashBoardIntent) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "DashBoard")
        Column(modifier = Modifier.fillMaxSize()) {
            Button(onClick = {
                onIntent(DashBoardIntent.NavigateToDetail)
            }) {
                Text(text = "this is DashBoard Screen")
            }
        }
    }
}