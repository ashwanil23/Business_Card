package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(Modifier.fillMaxWidth()) {
                    Card()
                }
            }
        }
    }
}
val backgroundColor = Color(0xFFD2E8D4)
val transparentBlack = Color(0xD9000000)
val darkGreen = Color(0xFF006D3B)
val darkBlue = Color(0xFF073042)
val lightGreen = Color(0xFF30DC80)
val moddedBlack = Color(0xD9140505)
@Composable
fun Card(){
    Column (
        Modifier.padding(top = 200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Column(
            Modifier
                .background(darkBlue)
                .padding(16.dp)
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(R.drawable.android_logo)
            Icon(
                painter = image,
                contentDescription = "This is business logo",
                tint = lightGreen,
            )
        }
        Column {
            CardInfo(
                name = "Ashwani Kumar",
                title = "Android Developer",
                mobile = "7678262877",
                social = "@Ashwani.L23",
                email = "mailid.ashwanikumar@gmail.com"
            )
        }
    }
}

@Composable
fun CardInfo(name: String,
             title: String,
             mobile: String,
             social: String,
             email: String,
             modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(4.dp),
    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp

            )
            Text(
                text = title,
                color = darkGreen

                )
        }
        Column(
            Modifier
                .fillMaxHeight()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                val painter = painterResource(R.drawable.baseline_phone_24)
                val contentDescription = "Phone"
                val tint = Color.DarkGray
                Icon(painter = painter,
                    contentDescription = contentDescription,
                    )
                Text(text = mobile,
                    modifier = Modifier.padding(horizontal = 8.dp))
            }
            Row {
                val painter = painterResource(R.drawable._047767_instagram_media_old_social_icon)
                val contentDescription = "share"
                val tint = Color.DarkGray
                Icon(painter = painter, contentDescription = contentDescription,
                    modifier = Modifier.padding(horizontal = 8.dp))
                Text(text = social)
            }

            Row {

                Column(Modifier.padding(start = 108.dp, end = 8.dp)
                    ,horizontalAlignment =Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    val painter = painterResource(R.drawable.baseline_email_24)
                    val contentDescription = "email"
                    val tint = Color.DarkGray
                    Icon(painter = painter, contentDescription = contentDescription,
                        )
                }
                Column(Modifier
                    ) {
                    Text(text = email)
                }

            }


        }
    }
}

@Preview(showBackground = true,
   name = "MyCard",
    backgroundColor = 0xCCFFCC)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Card()
    }
}