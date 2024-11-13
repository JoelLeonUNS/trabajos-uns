package com.example.appejercicioss09

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso02)

        val etEdad = findViewById<EditText>(R.id.etEdad);
        val btnRegresar = findViewById<Button>(R.id.btnRegresar);
        val btnCalcular = findViewById<Button>(R.id.btnCalcular);
        val tvResultado = findViewById<TextView>(R.id.tvResultado);

        btnRegresar.setOnClickListener { finish() }

        btnCalcular.setOnClickListener {
            val edadAna = etEdad.text.toString().toInt();
            val edades = calcularEdades(edadAna);
            val mensaje = "Ana tiene ${edades.first} años y Juan tiene ${edades.second} años.";
            tvResultado.text = mensaje;
        }
    }

    private fun calcularEdades(edadAna: Int): Pair<Int, Int> {
        val edadJuan = edadAna - 5
        return Pair(edadAna, edadJuan)
    }
}