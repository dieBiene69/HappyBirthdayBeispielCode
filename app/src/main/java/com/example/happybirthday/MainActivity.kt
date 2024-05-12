package com.example.happybirthday

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(
                        message = "Happy birthday Sam!",
                        from = "from Emma",
                        modifier = Modifier.padding(8.dp)//.fillMaxSize()

                    )
                }
            }
        }
    }
}
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    val counter = remember { mutableStateOf(0) } //mutable State
    Column(
       verticalArrangement = Arrangement.Center, // verteilung entlang der haupt achse (in dem Fall vertikal, bei Row horizontal)
        horizontalAlignment = Alignment.CenterHorizontally, //verteilung der NICHT Hauptachse
        modifier = modifier //hier beginnen die modifier
            .padding(8.dp)
            .fillMaxSize() //fillMaxSize füllt sich selbst auf die Gesamtverfügbare Fläche
            //.background(Color.Red)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center

        )
        Text(
            text = from + counter.value,
            fontSize = 36.sp,
            modifier = Modifier
                .background(Color.Blue)
                .clickable { counter.value += 1 } //klickbar gemacht
        )
    }
}

@Preview(
    showBackground = true,
    fontScale = 1.0f, //Preview Schritgröße
    showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy Birthday Sam!",from ="From Emma")
    }
}

@Preview(
    showBackground = true,
    fontScale = 1.5f, //Preview Schritgröße
    showSystemUi = true)
@Composable
fun BirthdayCardPreview2() {
    HappyBirthdayTheme {
        GreetingText(message = "Hallo!",from ="Marie")
    }
}
