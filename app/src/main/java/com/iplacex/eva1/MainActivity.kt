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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenUI()
        }
    }
}


@Composable
@Preview
fun MainScreenUI() {
    val contexto = LocalContext.current
    // Variable para rastrear si debemos mostrar la pantalla de cálculo de empleados a honorarios
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    val intent = Intent(contexto, EmpleadosHonorarioUI::class.java)
                    contexto.startActivity( intent )
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Calcular Empleados a Honorarios")
            }
            Button(
                onClick = {
                    val intent = Intent(contexto, EmpleadoContratoUI::class.java)
                    contexto.startActivity( intent )
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Calcular Empleados a Contrato")
            }
        }
    }





