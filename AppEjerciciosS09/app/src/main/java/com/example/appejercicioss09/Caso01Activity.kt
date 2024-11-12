package com.example.appejercicioss09

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appejercicioss09.R

class Caso01Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso01)

        val etNumero = findViewById<EditText>(R.id.etNumero);
        val btnRegresar = findViewById<Button>(R.id.btnRegresar);
        val btnVerificar = findViewById<Button>(R.id.btnVerificar);
        val tvResultado = findViewById<TextView>(R.id.tvResultado);

        btnRegresar.setOnClickListener { finish() }

        btnVerificar.setOnClickListener {
            val numero = etNumero.text.toString().toInt();
            val esPrimo = esPrimo(numero);
            val mensaje = if (esPrimo) "El número $numero es primo." else "El número $numero no es primo.";
            tvResultado.text = mensaje;
        }


    }

    private fun esPrimo(numero: Int): Boolean {
        if (numero <= 1) return false // Los números menores o iguales a 1 no son primos.

        for (i in 2..Math.sqrt(numero.toDouble()).toInt()) {
            if (numero % i == 0) {
                return false // Si el número es divisible por cualquier valor entre 2 y su raíz cuadrada, no es primo.
            }
        }
        return true // Si no tiene divisores, es primo.
    }
}