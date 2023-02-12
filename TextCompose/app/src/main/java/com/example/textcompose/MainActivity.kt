package com.example.textcompose

import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                CustomTextComposable()
            }
        }
    }
}

@Composable
fun CustomText1(){
    Text(text = "Custom Namaste Text",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(12.dp),
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End )
}

@Composable
fun CustomText2(){
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(
                textAlign = TextAlign.Center,

            )){
            withStyle(style = SpanStyle(
                color = Color.Magenta,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp)){
            append("A")
            }
            append("B")
            append("C")
            append("D")
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CustomText3(){
    Text(text = " leosum Text repeat".repeat(60),
        maxLines = 5,
        overflow = TextOverflow.Ellipsis)
}

@Composable
fun CustomText4() {
//    Column {
//    Text(text = stringResource(id = R.string.random_para))
//    SelectionContainer {
//        Text(text = "YOU CAN SELECT ME JUST LONG PRESS")
//        DisableSelection {
//            //Overlapping Issue
//            Text(text = "UN-SELECTABLE TEXT INSIDE SELECTION CONTAINER")
//        }
//    }
//    }

    SelectionContainer {
        Column {
            Text(text = stringResource(id = R.string.random_para))
            Text(text = "YOU CAN SELECT ME JUST LONG PRESS")
            DisableSelection {
            //Overlapping Issue
            Text(text = "UN-SELECTABLE TEXT INSIDE SELECTION CONTAINER")
            }
        }
    }

}

@Composable
fun CustomTextComposable() {
    CustomText1()
    CustomText2()
    CustomText3()
    Spacer(modifier = Modifier.height(10.dp))
    CustomText4()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
       CustomTextComposable()
    }
}