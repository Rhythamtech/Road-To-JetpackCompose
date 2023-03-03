package com.example.lazycolumncompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumncompose.model.Person

@Composable
fun CustomItem(person: Person) {

    Row(
        modifier = Modifier
            .clip(Shapes.medium)
            .background(Purple200)
            .fillMaxWidth()
            .padding(all = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )

        Text(
            text =person.firstName,
            color = Color.Black,
            fontSize = Typography.body1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = Typography.body1.fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    CustomItem(
        person = Person(
            id = 1,
            firstName = "Rhytham",
            lastName = "Negi",
            age = 22
        )
    )
}