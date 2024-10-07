package com.sylvinatests.jetpackkcomposeinstagram.ui.tweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sylvinatests.jetpackkcomposeinstagram.R

@Preview(showBackground = true, showSystemUi = true)
@Composable()
fun PreviewScreen() {
    MyScreenTweet(PaddingValues(0.dp))
}

@Composable
fun MyScreenTweet(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color(0xFF161D26))
    ) {
        BodyTweet()
        TweetDivider()
    }
}

@Composable
fun BodyTweet() {

    var chat by rememberSaveable {
        mutableStateOf(false)
    }

    var rt by rememberSaveable {
        mutableStateOf(false)
    }

    var like by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .height(50.dp),
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Photo User"
        )
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = "Sylvie Salazar",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(modifier = Modifier.padding(end = 8.dp), text = "@SylvieSR", color = Color.Gray)
                Text(modifier = Modifier.padding(end = 8.dp), text = "4h", color = Color.Gray)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "OptionsTweet",
                    tint = Color.White
                )
            }
            Text(
                text = "Este es un ejemplo de como debe verse un tweet construido completamente con Jetpack Compose",
                color = Color.White
            )
            Spacer(modifier = Modifier.size(12.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Media Tweet"
            )
            Spacer(modifier = Modifier.size(12.dp))
            Row {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = "Comment",
                            tint = Color.Gray
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "",
                            tint = Color.Gray
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "Comment",
                            tint = Color.Gray
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color.Green
                        )
                    },
                    isSelected = rt
                ) {
                    rt = !rt
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = "Comment",
                            tint = Color.Gray
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "",
                            tint = Color.Green
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
                
            }
        }
    }
}

@Composable
fun TweetDivider() {
    Divider(modifier = Modifier.padding(top = 4.dp). height(0.5.dp).fillMaxWidth(), color = Color.Gray)
}


@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color.Gray,
            fontSize = 12.sp,
        )
    }
}


