package com.example.boxcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boxcompose.ui.theme.BoxComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BoxExample()
                }
            }
        }
    }
}

@Composable
fun BoxExample() {
    Box(modifier = Modifier.fillMaxSize()
    , contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(250.dp)
                .background(Color.Yellow)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.TopCenter,
        ){

            Box(modifier = Modifier
                .width(35.dp)
                .height(35.dp)
                .background(Color.Cyan))

            Text(text = "Namaste Box Composable Function",
            style = MaterialTheme.typography.h1
            )

        }


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxComposeTheme {
        BoxExample()
    }
}