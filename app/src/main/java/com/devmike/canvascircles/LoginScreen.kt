package com.devmike.canvascircles

import android.util.Log
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devmike.canvascircles.ui.theme.CanvasCirclesTheme

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun LoginScreen(modifier: Modifier, onBackPressed : ( ) -> Unit) {

    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text("Login") }, navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "go back")

            }
        })
    }) { paddingValues ->


        Column(modifier = modifier
            .fillMaxSize()

            .drawBehind {
//top circle
                drawCircle(
                    radius = 300.dp.toPx(),
                    color = Color(0xFFC5F1BC),
                    center = Offset(-20.dp.toPx(), 450.dp.toPx())
                )

                            drawCircle(
                    radius = 300.dp.toPx(),
                    color = Color(0xFFC5F1BC),
                    center = Offset(200.dp.toPx(), 710.dp.toPx())

                )



            }
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,

            verticalArrangement = Arrangement.Top) {

            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Please enter your phone number and \npassword to continue.",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Phone Number",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Surface(
                modifier = Modifier.clip(
                    RoundedCornerShape(4.dp)
                )
            ) {


                OutlinedTextField(

                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    placeholder = { Text("+254701234567") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.LightGray.copy(0.15f)
                    )


                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Surface(
                modifier = Modifier.clip(
                    RoundedCornerShape(4.dp)
                )
            ) {
                OutlinedTextField(

                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("****") },

                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    suffix = {
                        Icon(Icons.Filled.RemoveRedEye, contentDescription = "hide /show password")
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.LightGray.copy(0.45f)
                    )


                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(onClick = {}) {
                    Text(text = "Forgot Password?")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    Log.d(this.toString(), "Some login action")
                }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Login", modifier = Modifier

                        .padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Don't have an account?")

                Text(
                    text = " Sign Up", color = MaterialTheme.colorScheme.primary

                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    CanvasCirclesTheme {
        LoginScreen(modifier = Modifier){

        }
    }
}