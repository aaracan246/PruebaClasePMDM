package com.example.pruebaclasepmdm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha  // Esto está aquí porque probé a hacerlo invisible pero no me salió aodwiofjl
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.pruebaclasepmdm.R
import com.example.pruebaclasepmdm.navigation.AppScreen


@Composable
fun FirstScreen(navControlador: NavController){
    FirstBody(navControlador)
}


@Composable
fun FirstBody(navControlador: NavController){

    // Estados a recordar:
    var nameRemember by remember { mutableStateOf("") }
    var ageRemember by remember { mutableStateOf("") }
    var displayColumn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.pink)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Card(modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)) {

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(  // Nombre
                    value = nameRemember,
                    onValueChange = { nameRemember = it },
                    label = { Text("Name") })

                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(  // Edad
                    value = ageRemember,
                    onValueChange = {  ageRemember = it  },
                    label = { Text("Age") })

                Spacer(modifier = Modifier.padding(8.dp))

                Button(
                    onClick = {

                        if (nameRemember.isNotBlank() && ageRemember.isNotBlank() && ageRemember.isDigitsOnly()){   // Controlamos que la edad solo pueda ser numérica y que los campos no estén vacíos.
                            navControlador.navigate(route = AppScreen.SecondScreen.route + "/" + nameRemember + "/" + ageRemember)
                        }
                        else{
                            displayColumn = true
                        }
                              },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.pink))) {
                    Text("Send data")
                }
                if (displayColumn){
                    ColumnaInvisible()  // Solo será visible si introducimos datos que no sean correctos
                }
            }
        }
    }
}


@Composable
fun ColumnaInvisible(){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .width(150.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("You must provide the required data.")
        }
}
