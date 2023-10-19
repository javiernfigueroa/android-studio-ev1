package com.iplacex.eva1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EmpleadoContratoUI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleado_contrato_ui)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val editTextSueldo = findViewById<EditText>(R.id.editTextSueldo)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        btnCalcular.setOnClickListener {
            val sueldoStr = editTextSueldo.text.toString()

            val sueldo = sueldoStr.toDoubleOrNull() ?: 0.0

            val resultado = sueldo / 1.2

            val resultadoFormateado = String.format("%.0f", resultado)

            textViewResultado.text = "El total a pagar es $$resultadoFormateado"
        }
    }
}
