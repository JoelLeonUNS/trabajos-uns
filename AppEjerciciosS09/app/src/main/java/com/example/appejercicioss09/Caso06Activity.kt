package com.example.appejercicioss09

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso06Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso06)

        // Referencias a los elementos del layout
        val btnRegresar = findViewById<Button>(R.id.btnRegresar);
        val btnVerificar = findViewById<Button>(R.id.btnVerificar);
        val etNumero = findViewById<EditText>(R.id.etNumero);
        val tvResultado = findViewById<TextView>(R.id.tvResultado);

        btnRegresar.setOnClickListener { finish() }

        // Acción al presionar el botón
        btnVerificar.setOnClickListener {
            val number = etNumero.text.toString().toIntOrNull()
            val factors = findFactors(number?:0)
            val isComposite = isCompositeNumber(factors)

            // Mostrar si el número es compuesto
            if (isComposite) {
                tvResultado.text = "$number es un número compuesto porque tiene más de dos divisores."
            } else {
                tvResultado.text = "$number no es un número compuesto."
            }
        }
    }

    // Función para encontrar los factores de un número
    private fun findFactors(number: Int): List<Int> {
        val factors = mutableListOf<Int>()
        for (i in 1..number) {
            if (number % i == 0) {
                factors.add(i)
            }
        }
        return factors
    }

    // Función para determinar si un número es compuesto
    private fun isCompositeNumber(factors: List<Int>): Boolean {
        return factors.size > 2
    }
}