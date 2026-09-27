package com.example.mvicompose.presentation.detaildata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    CounterScreen()
}

@Composable
fun CounterScreen() {
    // var counter: Int = 0
    var counter by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Count :$counter")
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { counter++ },
            ) {
                Text("Increment")
            }

            Button(onClick = { counter-- }) {
                Text("Decrement")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToggleColorPreview() {
    ToggleColor()
}

@Composable
fun ToggleColor() {
    var toggleColor by remember { mutableStateOf(true) }
    var backgroundColor = if (toggleColor == true) {
        Color.Blue
    } else {
        Color.Black
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .background(backgroundColor)
        ) { }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            toggleColor = !toggleColor
        }) {
            Text(text = "Color Change")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDaulogeBoxPreview() {
    AlertDailoogeBox()
}

@Composable
fun AlertDailoogeBox() {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (firstname.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .padding(bottom = 20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "hello $firstname $lastname")
                }
            }
        }
        Button(onClick = { showDialog = true }) {
            Text(text = "Add Detail hear")
        }
    }
    if (showDialog == true) {
        AddContentDialoge(
            onSaveClick = { f1name, f2name ->
                firstname = f1name
                lastname = f2name
                showDialog = false
            },
            onCloseClick = {
                showDialog = false
            }
        )
    }
}

@Composable
fun AddContentDialoge(
    onSaveClick: (String, String) -> Unit,
    onCloseClick: () -> Unit
) {
    var firstNameDialog by remember { mutableStateOf("") }
    var lastNameDialog by remember { mutableStateOf("") }

    AlertDialog(
        title = { Text("Please enter detail hear") },
        text = {
            Column() {
                TextField(
                    value = firstNameDialog,
                    onValueChange = { firstNameDialog = it },
                    label = { Text(text = "Enter firstname") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = lastNameDialog,
                    onValueChange = { lastNameDialog = it },
                    label = { Text(text = "Enter firstname") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        icon = {},
        onDismissRequest = {
            onCloseClick()
        },
        confirmButton = {
            Button(onClick = { onSaveClick(firstNameDialog, lastNameDialog) }) {
                Text(text = "Confirm button")
            }
        },
        dismissButton = {
            TextButton(onClick = { onCloseClick() }) {
                Text(text = "Cancel")
            }
        }
    )
}