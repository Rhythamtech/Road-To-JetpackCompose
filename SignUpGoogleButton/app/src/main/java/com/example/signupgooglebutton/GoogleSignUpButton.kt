package com.example.signupgooglebutton

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.signupgooglebutton.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleSignUpButton(
    text:String ="Signup with Google",
    loadingText:String = "Creating Account",
    icon : Painter =painterResource(id = R.drawable.ic_google_logo),
    onClicked:()->Unit
) {
    var clicked by remember { mutableStateOf(false) }

    Surface(shape = Shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black
        ),
        onClick = {clicked = !clicked}
    ) {
        Row(modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp
            )
            .height(36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription ="Google Logo",
                tint = Color.Unspecified,
                modifier = Modifier.padding(
                    end = 8.dp
                )
            )

            Text(text = if (clicked) loadingText else text)

            if (clicked){
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                )
                onClicked()
            }
        }
    }
}

@Preview
@Composable
fun PreviewGoogleSignUpButton(){
    GoogleSignUpButton(onClicked = {
    })
}