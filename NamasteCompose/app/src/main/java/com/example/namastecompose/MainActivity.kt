package com.example.namastecompose

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.namastecompose.ui.theme.NamasteComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Text(text = "Namaste Compose !")
            NamasteCompose()
        }
    }

    @Composable
    fun NamasteCompose(){
        Text(text = "Namaste Compose \nInside Composable function ")
    }

    @Preview
    @Composable
    fun PreviewCompose(){
        NamasteCompose()
    }

}

