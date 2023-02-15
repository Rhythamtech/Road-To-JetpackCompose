package com.example.cardcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardcompose.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard() {

    var expandState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 30,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expandState = !expandState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "My Title",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandState = !expandState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                }
            }

            if (expandState) {
                Text(
                    text = "Nullam finibus felis ex, nec dignissim purus cursus eu." +
                            " Aliquam dapibus, nisi vitae lacinia rhoncus, arcu eros posuere odio, " +
                            "vitae interdum lectus est id magna. Nam rhoncus lectus risus, semper interdum elit " +
                            "laoreet a. Nullam vel risus quam. Mauris a sem facilisis, dapibus eros eu, euismod sapien. Aenean id sapien at ipsum mollis porta." +
                            " Vestibulum sed varius felis. Etiam et tortor massa. Fusce ornare nec mi ut congue.",
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

    }
}

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard()
}