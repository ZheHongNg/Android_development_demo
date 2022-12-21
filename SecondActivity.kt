package com.example.multiscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.multiscreen.ui.theme.MultiScreenTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent2()
        }
    }
}

@Composable
fun MainContent2(){

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("GFG | Second Activity", color = Color.White)}, backgroundColor = Color(0xff0f9d58))
        },
        content = {MyContent2()}
        )
}

@Composable
fun MyContent2(){
    val mContext2= LocalContext.current
    val intent = (mContext2 as SecondActivity).intent
    val name = intent.getStringExtra("Name")

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Text("Hello $name", fontSize = 50.sp)
        Button(onClick = {
            mContext2.startActivity(Intent(mContext2,ThirdActivity::class.java))
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
        ) {
            Text("Go to Third Activity", color=Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MainContent2()
    }
