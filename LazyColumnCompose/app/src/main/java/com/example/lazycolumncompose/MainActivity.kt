package com.example.lazycolumncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumncompose.model.Person
import com.example.lazycolumncompose.repository.PersonRepository
import com.example.lazycolumncompose.ui.theme.CustomItem
import com.example.lazycolumncompose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var personRepository = PersonRepository()
            val data = personRepository.getAllData()
            var sections = listOf("A", "B", "C", "D", "F")

            Column {
               // un comment below to run on main app
                // LazyColumnExample(allData = data)

                LazyColumn(
                    contentPadding = PaddingValues(all = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    sections.forEach { section ->
                        //using sticky header
                        stickyHeader {
                            Text(
                                modifier = Modifier.background(Color.Magenta)
                                    .fillMaxWidth(),
                                text = "Section $section",
                                fontWeight = FontWeight.Black,
                                fontSize = Typography.body1.fontSize
                            )
                        }

                        items(10) { count ->
                            Text(text = "Index is $count")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LazyColumnExample(allData: List<Person>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = allData) { person ->
            CustomItem(person = person)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var personRepository = PersonRepository()
    val data = personRepository.getAllData()

    LazyColumnExample(allData = data)
}