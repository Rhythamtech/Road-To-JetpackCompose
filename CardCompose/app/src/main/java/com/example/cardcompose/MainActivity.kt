package com.example.cardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardcompose.ui.theme.CardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(12.dp)
                ) {
                ExpandableCard(
                    title = "my title",
                    description = "Random Text genrated"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  Column(modifier = Modifier
      .fillMaxSize()
      .background(Color.Gray)
      .padding(12.dp)) {
      ExpandableCard(
          title = "my title",
          description = "Random Text genrated"
      )  }
}