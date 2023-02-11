package com.example.columnrowscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Composable
//fun ColumnScope.Item(color: Color){
//    Surface(modifier = Modifier
//        .width(100.dp)
//        .weight(2f), color =color)
//    {}
//}

//@Composable
//fun RowScope.Item(color: Color){
//    Surface(modifier = Modifier
//        .height(100.dp)
//        .weight(2f), color =color)
//    {}
//}

@Composable
fun Item(color: Color){
    Surface(modifier = Modifier
        .height(100.dp)
        .width(20.dp),
        color =color)
    {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    Column(modifier = Modifier.fillMaxSize()) {
//        Item(color = MaterialTheme.colors.primary )
//        Item(color = MaterialTheme.colors.secondary)
//        Item(color = MaterialTheme.colors.error )
//    }
    Row(modifier = Modifier.fillMaxSize()
        , horizontalArrangement = Arrangement.SpaceBetween) {
        Item(color = MaterialTheme.colors.primary)
        Item(color = MaterialTheme.colors.secondary)
        Item(color = MaterialTheme.colors.error)
    }

}