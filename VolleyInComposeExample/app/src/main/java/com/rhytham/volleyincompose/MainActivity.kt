package com.rhytham.volleyincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rhytham.volleyincompose.ui.theme.VolleyInComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolleyInComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCompose()
                }
            }
        }
    }
}

@Composable
fun MainCompose() {
    val cardNum = rememberSaveable { mutableStateOf("") }
    val cardExp = rememberSaveable { mutableStateOf("") }
    val cardHolderName = listOf(
        "Savannah Pineda",
        "Maeve Gordon",
        "Reynaldo Hanna",
        "Jamarcus Arellano",
        "Kaia Santiago",
        "Olivia Cantrell",
        "Landin Ibarra",
        "Campbell Melton",
        "Ayden Trujillo",
        "Jadyn Gilmore",
        "Diamond Good",
        "Joshua Green"
    )

    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CreditCardM3(
            cardNumber = cardNum.value,
            cardHolderName = cardHolderName.random(),
            cardExpiry = cardExp.value
        )

        Button(onClick = {
            simpleRequest(context = context, cardNum, cardExp)
        }) { Text( text = "Load / Re-load")}
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VolleyInComposeExampleTheme {
        MainCompose()
    }
}