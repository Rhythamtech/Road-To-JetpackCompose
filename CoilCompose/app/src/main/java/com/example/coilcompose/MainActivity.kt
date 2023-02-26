package com.example.coilcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                CoilCompose()
            }
        }
    }
}

@Composable
fun CoilCompose() {
    Column {
        var text by remember { mutableStateOf("") }
        Text(text = text)
        AsyncImage(
            model = ImageRequest.Builder(
                context = LocalContext.current
            )
                .data("https://placehold.jp/3d4070/ffffff/500x500.png?text=IMAGE%20")
                .crossfade(true)
                .addHeader("IMAGE", "CONTENT IS HERE")
                .build(),
            onState = { painterState: AsyncImagePainter.State ->
                if (painterState is AsyncImagePainter.State.Loading) {
                    text = "Loading Image"
                }
                if (painterState is AsyncImagePainter.State.Success) {
                    text = "Image load sucessfully"
                }
            },
            contentDescription = "Image here",
            modifier = Modifier.clip(CircleShape)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        CoilCompose()
    }
}