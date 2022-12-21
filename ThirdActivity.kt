package com.example.multiscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multiscreen.ui.theme.MultiScreenTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContent3()
        }
    }
}

@Composable
fun MyContent3(){
    Scaffold(
        topBar = { TopAppBar(title = { Text("GFG | Main Activity", color = Color.White)}, backgroundColor = Color(0xff0f9d58))

        },
        content = {

            MyText()
        }
    )
}

@Composable
fun MyText(){
    Column( Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Text("Hello World", fontSize = 24.sp)

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MyContent3()
}