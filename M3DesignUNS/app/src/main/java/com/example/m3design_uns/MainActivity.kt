package com.example.m3design_uns

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verificar si el Fragment ya está cargado para evitar recargarlo al rotar la pantalla
        if (savedInstanceState == null) {
            // Reemplazar el contenedor con el fragmento de becas
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, BecasFragment())
                .commit()
        }
    }
}