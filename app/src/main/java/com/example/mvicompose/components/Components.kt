package com.example.mvicompose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvicompose.R
import com.example.mvicompose.ui.theme.Typography

//
//@Preview(showBackground = true)
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

//@Preview(showBackground = true)
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

//
//@Preview(showBackground = true)
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

//
//@Preview(showBackground = true)
@Composable
fun CardCompose() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .padding(top = 100.dp)
                    .border(2.dp, color = Color.Gray)
                    .background(color = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Delete Confirmation",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Are you sure to delete this items?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Magenta)
                                .padding(
                                    horizontal = 15.dp,
                                    vertical = 10.dp
                                )
                        ) {
                            Text(
                                text = "Action",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(15.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_profile_img),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Android Dev",
                    fontSize = 20.sp,
                    color = Color.Blue,
                    modifier = Modifier.padding(bottom = 5.dp),
                    style = Typography.bodyLarge
                )
                Text(
                    text = "JetPack Compose",
                    fontSize = 20.sp,
                    color = Color.Blue,
                )
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge,
        fontSize = 20.sp,
        color = Color.Blue,
        modifier = Modifier.padding(top = 13.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ContentCardPreview() {
    ContentCard(content = {})
}

@Composable
fun ContentCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}


