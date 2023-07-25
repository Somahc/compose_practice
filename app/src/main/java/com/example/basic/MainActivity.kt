package com.example.basic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basic.ui.theme.BasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    SimpleFilledTextFieldSample()
//                    Box(
//                        contentAlignment = Alignment.Center
//                    ) {
//                        ButtonSample()
//                    }
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        ImageSample()
                    }
                }
            }
        }
    }
}

@Composable
fun LayoutSample() {
    Column(
//        horizontalArrangement = Arrangement.spacedBy(8.dp)
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Welcome to, ",
            color = colorResource(id = R.color.purple_200)
            )
        Text("Summer Intern", color = Color.Blue)
        Text("in 2023", color = Color.Green)
    }
}

@Preview
@Composable
fun PreviewLayoutSample() {
    LayoutSample()
}

@Composable
fun ImageSample() {
    val imageModifier = Modifier
        .size(200.dp)
        .clip(CircleShape)
//        .clip(RoundedCornerShape(24.dp))
    Image(
        painter = painterResource(id = R.drawable.sample_image),
        contentDescription = "サンプル画像　ダックスフンド",
        modifier = imageModifier,
        contentScale = ContentScale.Crop,
    )
}

@Preview
@Composable
fun PreviewImageSample() {
    ImageSample()
}

@Composable
fun ButtonSample() {
    Button(
        onClick = { Log.d("Button", "Clicked") },
//            shape = MaterialTheme.shapes.extraSmall,
//            border = BorderStroke(2.dp, Color.DarkGray),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color.Green,
//                contentColor = Color.Black
//            )
    ){
        Icon(
            Icons.Filled.CheckCircle,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Tap Button")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonSample() {
    ButtonSample()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingText() {
    Text(stringResource(R.string.greeting),
        color = Color.Red,
        fontSize = 8.sp
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Welcome Summer") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Greet Label") }
    )
}

@Preview(showBackground = false)
@Composable
fun GreetingTextPreview() {
     BasicTheme {
         GreetingText()
     }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicTheme {
        Greeting("Android")
    }
}