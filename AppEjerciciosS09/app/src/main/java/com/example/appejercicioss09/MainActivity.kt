package com.example.appejercicioss09

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appejercicioss09.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCaso01 = findViewById<Button>(R.id.btnActividad1)
        val btnCaso02 = findViewById<Button>(R.id.btnActividad2)
        val btnCaso03 = findViewById<Button>(R.id.btnActividad3)
        val btnCaso04 = findViewById<Button>(R.id.btnActividad4)
        val btnCaso05 = findViewById<Button>(R.id.btnActividad5)
        val btnCaso06 = findViewById<Button>(R.id.btnActividad6)

        btnCaso01.setOnClickListener { navegarActividad(1) }
        btnCaso02.setOnClickListener { navegarActividad(2) }
        btnCaso03.setOnClickListener { navegarActividad(3) }
        btnCaso04.setOnClickListener { navegarActividad(4) }
        btnCaso05.setOnClickListener { navegarActividad(5) }
        btnCaso06.setOnClickListener { navegarActividad(6) }


    }

    private fun navegarActividad(nro: Int) {
        var intent = Intent(this, MainActivity::class.java)
        when (nro) {
            1 -> intent = Intent(this, Caso01Activity::class.java)
            2 -> intent = Intent(this, Caso02Activity::class.java)
            3 -> intent = Intent(this, Caso03Activity::class.java)
            4 -> intent = Intent(this, Caso04Activity::class.java)
            5 -> intent = Intent(this, Caso05Activity::class.java)
            6 -> intent = Intent(this, Caso06Activity::class.java)
        }
        startActivity(intent);
    }
}