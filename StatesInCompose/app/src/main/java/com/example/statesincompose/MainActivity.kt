package com.example.statesincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.statesincompose.ui.theme.StatesInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterCount()

        }
    }
}

@Composable
fun CharacterCount() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(10.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text =  "No of Characters : ${text.length}"
            , modifier = Modifier.padding(10.dp)
            , fontSize = 20.sp
            , maxLines = Int.MAX_VALUE
        )
        TextField(value =text , onValueChange = {
            text=it
        }, label = { Text(text = "Your Thoughts")})
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StatesInComposeTheme {
        CharacterCount()
    }
}