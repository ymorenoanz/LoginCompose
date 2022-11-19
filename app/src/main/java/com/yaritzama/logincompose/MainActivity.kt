package com.yaritzama.logincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yaritzama.logincompose.ui.theme.LoginComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun LoginCard(){
    Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp))
        {
            Row(modifier = Modifier
                .padding(16.dp)
                .align(alignment = CenterHorizontally)) {
                Text(text = "LOGIN", fontStyle = FontStyle.Italic,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }
            Row(modifier = Modifier.padding(16.dp))
            {
                var value by remember { mutableStateOf("") }
                TextField(value = value, onValueChange = {value = it},
                    label = {Text(text = "Enter username" )})
            }
            Row(modifier = Modifier.padding(16.dp))
            {
                var password by remember { mutableStateOf("") }
                TextField(value = password, onValueChange = {password = it},
                    label = { Text(text = "Enter password")},
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }
            Row(modifier = Modifier
                .padding(16.dp)
                .align(alignment = CenterHorizontally)) {
                Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(20.dp)) {
                    Text(text = "Login")
                }
            }

            Row(modifier = Modifier
                .padding(16.dp)
                .align(alignment = CenterHorizontally)) {
                var enabled by remember { mutableStateOf(true)}
                Text(text = "Forgot password?", modifier = Modifier
                    .clickable { enabled = true}, fontSize = 16.sp)
            }
        }
    }
}

@Preview
@Composable
fun MainContainer(){
   Box(modifier = Modifier.fillMaxSize()){
      Box(
          Modifier
              .align(Alignment.TopCenter)
              .background(Color(0xFF5870cb))
              .fillMaxWidth()
              .fillMaxHeight(0.50f)){
          ImageResource(Modifier.align(Alignment.TopCenter))
      }

       Box(Modifier
               .align(Alignment.Center)){
           LoginCard()
       }

       Box(
           Modifier
               .align(Alignment.BottomCenter)
               .background(Color.Cyan)){
       }
   }
}

@Composable
fun ImageResource(modifier: Modifier = Modifier){
    val image: Painter = painterResource(id = R.drawable.login)
    Image(painter = image, contentDescription = "", modifier = modifier)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginComposeTheme {
        MainContainer()
    }
}