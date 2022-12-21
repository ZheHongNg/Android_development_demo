package com.example.multiscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.multiscreen.ui.theme.MultiScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MainContent()
        }
    }
}

@Composable
fun MainContent(){
    Scaffold(
        topBar = { TopAppBar(title = { Text("GFG | Main Activity", color = Color.White)}, backgroundColor = Color(0xff0f9d58))

        },
        content = { MyContent()}
    )
}



@Composable
fun MyContent(){

    var userName by remember {
        mutableStateOf("")
    }
    val mContext = LocalContext.current

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextField(
            value = userName,
            onValueChange =  {userName = it},
            label = { Text("Enter name")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            Modifier.height(16.dp)

        )
        Button(onClick = {
            val intent = Intent(mContext,SecondActivity::class.java)
            intent.putExtra("Name", userName)
            mContext.startActivity(intent)

        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),


        ) {
            Text("Go to Second Activity", color=Color.White)
        }
        Button(onClick = {
            mContext.startActivity(Intent(mContext,ThirdActivity::class.java))
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
        ) {
            Text("Go to Third Activity", color=Color.White)
        }
    }


}

@Composable
fun NameField(value:String,onValueChange:(String)->Unit){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Enter name")},
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier.fillMaxWidth()
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}