package com.example.layoutcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.provider.Telephony.Sms.Conversations
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutcompose.ui.theme.LayoutComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutComposeTheme {
                Surface{
                    GreetingCard(msg = Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}

@Composable
fun GreetingCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp), verticalAlignment =Alignment.CenterVertically){
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription ="profile picture",
            modifier= Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape),
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }){
            Text(
                text = msg.author,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = msg.body,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            )
        }
    }
}

@Composable
fun MsgCoversation(messageList:List<Message>){
    LazyColumn{
        items(messageList){
            message->GreetingCard(msg =message)
        }
    }

}

@Preview( name = "light Mode",showBackground = true)
@Preview( name = "dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutComposeTheme {
        Surface{
//            GreetingCard(msg= Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!"))
            MsgCoversation(SampleData.conversationSample)
        }
    }
}