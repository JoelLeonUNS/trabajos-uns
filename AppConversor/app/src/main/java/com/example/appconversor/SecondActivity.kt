package com.example.appconversor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appconversor.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    // 1. Declaramos la variable binding
    private lateinit var binding: ActivitySecondBinding
    //
    private val rateDollarToSoles = 3.8 // Ejemplo de tasa de conversión
    private val rateSolesToDollar = 1 / rateDollarToSoles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 2. Inicializar el binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. Obtenemos el valor de username
        val username = intent.getStringExtra("username")

        // 4. Mostramos el mensaje de bienvenida
        binding.tvWelcome.text = "Bienvenido $username"

        val spinnerCurrency = findViewById<Spinner>(R.id.spinner_currency)
        val editTextAmount = findViewById<EditText>(R.id.editText_amount)
        val buttonConvert = findViewById<Button>(R.id.button_convert)
        val textViewResult = findViewById<TextView>(R.id.textView_result)

        buttonConvert.setOnClickListener {
            val amount = editTextAmount.text.toString().toDoubleOrNull()
            if (amount != null) {
                val selectedCurrency = spinnerCurrency.selectedItemPosition
                val result = when (selectedCurrency) {
                    0 -> amount * rateSolesToDollar // Soles a Dólares
                    1 -> amount * rateDollarToSoles // Dólares a Soles
                    else -> 0.0
                }
                textViewResult.text = "Resultado: %.2f".format(result)
            } else {
                textViewResult.text = "Por favor, ingrese un monto válido"
            }
        }

        // 5. Configuramos el botón logout
        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}