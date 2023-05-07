package com.rhytham.ktorclient.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rhytham.ktorclient.Model.Post
import com.rhytham.ktorclient.UiComponent.CodeCard
import com.rhytham.ktorclient.UiComponent.FilterChipGroup
import com.rhytham.ktorclient.Network.ApiRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Column(modifier = Modifier.padding(all = 12.dp)){

        val chipsList = listOf("/POST", "/GET", "/DELETE", "/PUT")
        var headLine by remember { mutableStateOf(chipsList[0]) }
        val scope  = rememberCoroutineScope()
        var jsonRepose  by remember { mutableStateOf("") }
        val apiRepo = ApiRepository()

        val post = Post(
            title = "How to Make HTTP Requests With Ktor-Client in Android",
            id = 1,
            body = "Ktor is a client-server framework that helps us build applications in Kotlin. It is a modern asynchronous framework backed by Kotlin coroutines.",
            userId = "1"
        )


        Text( style =MaterialTheme.typography.headlineLarge,
            text = headLine)
        Divider()
        FilterChipGroup(items = chipsList,
            onSelectedChanged = { selectedIndex:Int ->
                headLine = chipsList[selectedIndex]
                jsonRepose =""
            })

        OutlinedTextField( modifier = Modifier.fillMaxWidth(),
            value = "https://jsonplaceholder.typicode.com/",
            onValueChange ={},
            readOnly = true,
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(modifier = Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .width(200.dp),
            onClick = {

                scope.launch {
                    when(headLine){
                        "/POST" -> {
                            jsonRepose = apiRepo.createNewPost(post).toString()

                        }
                        "/GET" -> {
                            jsonRepose = apiRepo.getAllPosts().toString()

                        }
                        "/PUT" -> {
                            // Use PUT request to Update data
                            jsonRepose = apiRepo.updatePost(
                                id=1,
                                post = post ).toString()

                        }
                        "/DELETE" -> {
                            jsonRepose = apiRepo.deletePost( id = 2).toString()

                        }
                    }
                }

            }) {
            Text(text = "Send")
        }

        CodeCard(jsonStr = jsonRepose)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreenLight() {
    HomeScreen()
}

