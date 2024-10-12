package com.example.appcalculadora
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private var currentNumber: String = ""
    private var previousNumber: String = ""
    private var operator: String = ""
    private var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textView_result)

        // Números
        val numberButtons = listOf(
            findViewById<Button>(R.id.button_0),
            findViewById<Button>(R.id.button_1),
            findViewById<Button>(R.id.button_2),
            findViewById<Button>(R.id.button_3),
            findViewById<Button>(R.id.button_4),
            findViewById<Button>(R.id.button_5),
            findViewById<Button>(R.id.button_6),
            findViewById<Button>(R.id.button_7),
            findViewById<Button>(R.id.button_8),
            findViewById<Button>(R.id.button_9)
        )

        // Operaciones
        val addButton = findViewById<Button>(R.id.button_add)
        val subtractButton = findViewById<Button>(R.id.button_subtract)
        val multiplyButton = findViewById<Button>(R.id.button_multiply)
        val divideButton = findViewById<Button>(R.id.button_divide)
        val equalsButton = findViewById<Button>(R.id.button_equals)
        val clearButton = findViewById<Button>(R.id.button_clear)

        // Configuración de los botones numéricos
        numberButtons.forEach { button ->
            button.setOnClickListener {
                currentNumber += button.text
                textViewResult.text = currentNumber
            }
        }

        // Operaciones
        addButton.setOnClickListener { operate("+") }
        subtractButton.setOnClickListener { operate("-") }
        multiplyButton.setOnClickListener { operate("*") }
        divideButton.setOnClickListener { operate("/") }

        // Botón de igual
        equalsButton.setOnClickListener {
            if (operator.isNotEmpty() && currentNumber.isNotEmpty()) {
                calculate()
                textViewResult.text = result.toString()
                currentNumber = result.toString()
                operator = ""
            }
        }

        // Botón de limpiar
        clearButton.setOnClickListener {
            currentNumber = ""
            previousNumber = ""
            operator = ""
            result = 0.0
            textViewResult.text = "0"
        }
    }

    private fun operate(op: String) {
        if (currentNumber.isNotEmpty()) {
            operator = op
            previousNumber = currentNumber
            currentNumber = ""
        }
    }

    private fun calculate() {
        val num1 = previousNumber.toDouble()
        val num2 = currentNumber.toDouble()
        result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else 0.0 // Evitar división entre 0
            else -> 0.0
        }
    }
}