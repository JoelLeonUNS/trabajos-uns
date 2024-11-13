package com.example.appejercicioss09

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Caso04Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caso04)

        val btnRegresar = findViewById<Button>(R.id.btnRegresar);
        val workersInput = findViewById<EditText>(R.id.etTrabajadores)
        val daysInput = findViewById<EditText>(R.id.etDias)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnRegresar.setOnClickListener { finish() }

        // Adaptador para el Spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.options_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Acción al presionar el botón
        btnCalcular.setOnClickListener {
            val selectedOption = spinner.selectedItem.toString()

            if (selectedOption == "Calcular días") {
                val workers = workersInput.text.toString().toIntOrNull()
                val initialWorkers = 4
                val initialDaysFixed = 6

                if (workers != null && workers > 0) {
                    val newDays = (initialWorkers * initialDaysFixed) / workers
                    tvResultado.text = "Con $workers trabajadores, tomaría $newDays días construir el muro."
                } else {
                    tvResultado.text = "Por favor ingresa un número válido de trabajadores."
                }
            } else if (selectedOption == "Calcular trabajadores") {
                val days = daysInput.text.toString().toIntOrNull()
                val initialWorkers = 4
                val initialDaysFixed = 6

                if (days != null && days > 0) {
                    val requiredWorkers = (initialWorkers * initialDaysFixed) / days
                    tvResultado.text = "Para construir el muro en $days días, necesitarás $requiredWorkers trabajadores."
                } else {
                    tvResultado.text = "Por favor ingresa un número válido de días."
                }
            }
        }

        // Mostrar/ocultar campos según la selección del Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedOption = parent.getItemAtPosition(position).toString()
                if (selectedOption == "Calcular días") {
                    workersInput.visibility = View.VISIBLE
                    daysInput.visibility = View.GONE
                } else if (selectedOption == "Calcular trabajadores") {
                    workersInput.visibility = View.GONE
                    daysInput.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hacer nada si no se selecciona nada
            }
        }
    }
}