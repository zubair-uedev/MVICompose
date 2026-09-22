package com.example.mvicompose.presentation.detaildata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvicompose.components.ContentCard
import com.example.mvicompose.components.ProfileHeader
import com.example.mvicompose.components.SectionTitle
import com.example.mvicompose.ui.theme.darkGray


@Preview(showBackground = true)
@Composable
fun DetailData() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader()
            //this column contain is content area
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SectionTitle(title = "Bio")
                ContentCard {
                    Text(
                        text = "Lorem ipsum is a standard placeholder or dummy text widely used in graphic design, web development, and publishing to preview visual layouts.",
                        lineHeight = 24.sp,
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                }
                SectionTitle(title = "Education")
                ContentCard {
                    Column() {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Bachelor Of Computer Science",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "UE Lahore",
                                color = darkGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "2020-2033",
                                color = Color.LightGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Divider(
                            modifier = Modifier.padding(10.dp),
                            color = Color.LightGray
                        )
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Master Computer Science",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "UE Lahore",
                                color = darkGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "2020-2033",
                                color = Color.LightGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Divider(
                            modifier = Modifier.padding(10.dp),
                            color = Color.LightGray
                        )
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "PHD In Computer Science",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "UE Lahore",
                                color = darkGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "2020-2033",
                                color = Color.LightGray,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Divider(
                            modifier = Modifier.padding(10.dp),
                            color = Color.LightGray
                        )
                    }
                }
                SectionTitle("Achievements")
                ContentCard {
                    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Text(
                                "=>",
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(end = 6.dp)
                            )
                            Text(
                                "You can  implement new things as soon as possible",
                                color = Color.Black,
                                fontSize = 11.sp,

                                )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Text(
                                "=>",
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(end = 6.dp)
                            )
                            Text(
                                "You can  implement new things as soon as possible",
                                color = Color.Black,
                                fontSize = 11.sp,

                                )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Text(
                                "=>",
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(end = 6.dp)
                            )
                            Text(
                                "You can  implement new things as soon as possible",
                                color = Color.Black,
                                fontSize = 11.sp,

                                )
                        }
                    }
                }
            }
        }
    }
}
