package com.example.appejercicioss09

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso03)

        val etBase = findViewById<EditText>(R.id.etBase);
        val etAltura = findViewById<EditText>(R.id.etAltura);
        val btnRegresar = findViewById<Button>(R.id.btnRegresar);
        val btnCalcular = findViewById<Button>(R.id.btnCalcular);
        val tvResultado = findViewById<TextView>(R.id.tvResultado);

        btnRegresar.setOnClickListener { finish() }

        btnCalcular.setOnClickListener {
            val base = etBase.text.toString().toDouble();
            val altura = etAltura.text.toString().toDouble();
            val area = base * altura / 2;
            tvResultado.text = "El área del triángulo es $area";
        }

    }


}