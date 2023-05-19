package com.rhytham.navigationincomposeexample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FirstScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Screen\n" +
                    "Click me to go to Second Screen",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.clickable(onClick = {
                // this will navigate to the second screen
                navController.navigate("second_screen")
            })
        )
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen\n" +
                    "Click me to go to Third Screen",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.clickable(onClick = {
                // this will navigate to third screen
                navController.navigate("third_screen")
            })
        )
    }
}

@Composable
fun ThirdScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Third Screen",
            color = Color.Green,
            style = TextStyle(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}