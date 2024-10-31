import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

import androidx.compose.runtime.Composable

@Composable
fun MyCard(
//    iconResId: Int,
    title: String,
    content: String,
    isSwitchVisible: Boolean = false
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
//            Image(
//                painter = painterResource(id = iconResId),
//                contentDescription = title,
//                modifier = Modifier
//                    .size(48.dp)
//                    .align(Alignment.CenterHorizontally)
//            )
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = content,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 8.dp)
            )
            if (isSwitchVisible) {
                Switch(
                    checked = false,
                    onCheckedChange = { },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

fun main() = application {
   Window(
       onCloseRequest = ::exitApplication,
       title = "Compose for Desktop",
       state = rememberWindowState(width = 300.dp, height = 300.dp)
   ) {
       val count = remember { mutableStateOf(0) }
       MaterialTheme {
           Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
               MyCard("hello", "world")

               Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                   onClick = {
                       count.value++
                   }) {
                   Text(if (count.value == 0) "Hello World" else "Clicked ${count.value}!")
               }
               Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                   onClick = {
                       count.value = 0
                   }) {
                   Text("Reset")
               }
           }
       }
   }
}
