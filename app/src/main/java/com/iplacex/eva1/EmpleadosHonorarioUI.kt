package com.iplacex.eva1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iplacex.eva1.ui.theme.Eva1Theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class EmpleadosHonorarioUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Eva1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   EmpleadoHonorariosUI()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun EmpleadoHonorariosUI() {
    val contexto = LocalContext.current
    //Creamos las variables que necesitamos
    val estadoInicial = ""
    val retencionHonorario = 1.13
    var sueldo by remember { mutableStateOf( estadoInicial) }
    var retencion by remember { mutableStateOf( retencionHonorario ) }
    var resultado by remember { mutableStateOf( estadoInicial ) }

    //hay que usar un layout para que no se apilen
    // que es un layout? esto => Column() los deja vertical
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    { //Creo un titulo de la vista
        Text(text = "Calcula los sueldos a Honorarios")
        //Creo Texfields para personalizar
        TextField(
            value = sueldo,
            onValueChange = {sueldo = it},
            label = { Text(text = "Ingrese sueldo")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Button(onClick = {
            val sueldoHonorario = sueldo.toIntOrNull() ?: 0
            val retencionHonorario = retencion
            val total = calculaHonorarios(sueldoHonorario, retencionHonorario)
            resultado = "El total a pagar es $$total"
        }) {
            Text(text = "Calcular sueldo")
        }
        Text(text = resultado)
        Button(
            onClick = {
                val intent = Intent(contexto, MainActivity::class.java)
                contexto.startActivity( intent )},
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Volver")
        }
    }
}

fun calculaHonorarios(sueldo: Int, retencion: Double): Int {
    val resultado = sueldo / retencion
    return resultado.toInt() //
}
