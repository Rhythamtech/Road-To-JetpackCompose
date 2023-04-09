package com.rhytham.m3cloudnotes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.M3CloudNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    M3CloudNotesTheme{

        Box(
            modifier = Modifier.background(
                color = MaterialTheme.colorScheme.background
            )
        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    text = "Main Heading",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    text = "Answer misery adieus add wooded how nay men before though. Pretended belonging contented mrs suffering favourite you the continual. Mrs civil nay least means tried drift. Natural end law whether but and towards certain. Furnished unfeeling his sometimes see day promotion. Quitting informed concerns can men now. Projection to or up conviction uncommonly delightful continuing. In appetite ecstatic opinions hastened by handsome admitted.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    modifier = Modifier.padding(all = 12.dp),
                    style = MaterialTheme.typography.titleMedium,
                    text = "Sub Heading"
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    text = "Answer misery adieus add wooded how nay men before though. Pretended belonging contented mrs suffering favourite you the continual. Mrs civil nay least means tried drift. Natural end law whether but and towards certain. Furnished unfeeling his sometimes see day promotion. Quitting informed concerns can men now. Projection to or up conviction uncommonly delightful continuing. In appetite ecstatic opinions hastened by handsome admitted.",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Button(modifier = Modifier
                    .padding(ButtonDefaults.TextButtonContentPadding)
                    .align(alignment = Alignment.End),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Read more")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    text = "Main Heading",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    text = "Answer misery adieus add wooded how nay men before though. Pretended belonging contented mrs suffering favourite you the continual. Mrs civil nay least means tried drift. Natural end law whether but and towards certain. Furnished unfeeling his sometimes see day promotion. Quitting informed concerns can men now. Projection to or up conviction uncommonly delightful continuing. In appetite ecstatic opinions hastened by handsome admitted.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    modifier = Modifier.padding(all = 12.dp),
                    style = MaterialTheme.typography.titleMedium,
                    text = "Sub Heading"
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 12.dp),
                    text = "Answer misery adieus add wooded how nay men before though. Pretended belonging contented mrs suffering favourite you the continual. Mrs civil nay least means tried drift. Natural end law whether but and towards certain. Furnished unfeeling his sometimes see day promotion. Quitting informed concerns can men now. Projection to or up conviction uncommonly delightful continuing. In appetite ecstatic opinions hastened by handsome admitted.",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Button(modifier = Modifier
                    .padding(ButtonDefaults.TextButtonContentPadding)
                    .align(alignment = Alignment.End),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Read more")
                }

            }
        }
            ExtendedFloatingActionButton(modifier = Modifier
                .padding(FloatingActionButtonDefaults.LargeIconSize)
                .align(alignment = Alignment.BottomEnd),
                elevation = FloatingActionButtonDefaults.elevation(),
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Show Dialog")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Show Dialog message")
            }
        }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            Toast.makeText(context, "Dismissed Dialog", Toast.LENGTH_SHORT).show()
        },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    Toast.makeText(context, "Confirmed Dialog", Toast.LENGTH_SHORT).show()
                }) {
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text = "Confirm")

                }

            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text="Dismiss")
                }
            },
            title = {
                Text(
                    style = MaterialTheme.typography.headlineLarge,
                    text = "M3 Dialog")
            },
            text = {
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = "This area typically contains the supportive text " +
                            "which presents the details regarding the Dialog's purpose.",
                )
            }
        )
    }
    }



}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting()
}