package com.example.pruebaclasepmdm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pruebaclasepmdm.R

@Composable
fun SecondScreen(navControlador: NavController, name: String?, age: Int?){
    SecondBody(navControlador, name, age)
}


@Composable
fun SecondBody(navControlador: NavController, name: String?, age: Int?){



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.pink)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Card(modifier = Modifier.fillMaxSize().padding(32.dp)) {

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {


                name?.let {     // Nombre
                    Text("Welcome back, $it.")
                }

                age?.let {      // Edad
                    Text("You are $it years old.")
                }

                Spacer(modifier = Modifier.padding(8.dp))

                Button(
                    onClick = { navControlador.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.pink))) {
                    Text("Return")
                }
            }
        }
    }
}