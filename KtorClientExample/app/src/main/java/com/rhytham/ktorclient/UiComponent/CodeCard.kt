package com.rhytham.ktorclient.UiComponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CodeCard(jsonStr: String) {
    val scrollState = rememberScrollState()

    Card(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(
            state = scrollState,
            enabled = true
        )
        .padding(all = 8.dp),
    ) {
        Text(
            modifier = Modifier.padding(all = 12.dp),
            text = jsonStr,
            fontFamily = FontFamily.Monospace
        )
    }

}

@Preview
@Composable
fun PreviewCodeCard() {
    CodeCard(
        jsonStr = "{\n" +
                "  id: 101,\n" +
                "  title: 'foo',\n" +
                "  body: 'bar',\n" +
                "  userId: 1\n" +
                "}"
    )
}
