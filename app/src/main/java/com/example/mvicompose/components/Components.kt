package com.example.mvicompose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvicompose.R

@Preview(showBackground = true)
@Composable
fun JetComposePreview() {
    JetCompose()
}

@Composable
fun JetCompose() {
    Card() {
        var expend by remember { mutableStateOf(false) }
        Column(modifier = Modifier.clickable { expend = !expend }) {
            Image(
                painter = painterResource(R.drawable.ic_compose_), contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            AnimatedVisibility(visible = expend) {
                Text(
                    text = "JetPack Compose",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowComposable() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MessageCard(
                Message("zubair", "Borla", img = R.drawable.ic_android_img),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            MessageCard(
                Message("zubair", "Borla", img = R.drawable.ic_android_img),
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    MessageCard(
        message = Message("", "", 1), modifier = Modifier
    )
}

data class Message(
    val name: String,
    val author: String,
    val img: Int
)

@Composable
fun MessageCard(message: Message, modifier: Modifier) {
    Row(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_compose_),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = message.name, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = message.author, fontSize = 15.sp)
        }
    }
}



