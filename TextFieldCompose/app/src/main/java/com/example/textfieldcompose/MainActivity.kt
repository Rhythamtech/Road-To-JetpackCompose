package com.example.textfieldcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Greeting()
        }
    }
}


@Composable
fun Greeting() {

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = "Value",
            onValueChange = {},
            modifier = Modifier
                .padding(8.dp)
                .background(Color.LightGray)
        )


        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            modifier = Modifier.padding(8.dp)
        )

        TextField(
            value = text2,
            onValueChange = {
                text2 = it
            },
            label = {
                Text(text = "Text Label")
            },
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = text3,
            onValueChange = {
                text3 = it
            },
            modifier = Modifier
                .padding(8.dp)
                .background(Color.LightGray),
            label = {
                Text(text = "Enter EMAIL ID") },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Text Box")
            },
            trailingIcon = {
                IconButton(onClick = {
                    Log.d("trailingClick","Trailing Icon Clicked")
                }) {
                Icon(imageVector = Icons.Filled.Done, contentDescription = "Correct email")
                }

            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    Log.d("keyAction","Email Validated")
                }
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting()

}