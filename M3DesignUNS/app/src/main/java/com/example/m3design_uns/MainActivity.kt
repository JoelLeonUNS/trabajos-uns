package com.example.m3design_uns

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa el BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)



        // Verificar si el Fragment ya está cargado para evitar recargarlo al rotar la pantalla
        if (savedInstanceState == null) {
            // Reemplazar el contenedor con el fragmento de becas
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        }

        // Manejar los clics en el BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.navigation_home -> HomeFragment() // Cambia el fragmento según corresponda
                R.id.navigation_anuncios -> AnunciosFragment() // Cambia el fragmento según corresponda
                R.id.navigation_becas -> BecasFragment() // Cambia el fragmento según corresponda
                //R.id.navigation_capacitaciones -> ProfileFragment() // Cambia el fragmento según corresponda
                //R.id.navigation_comunidad -> SettingsFragment() // Cambia el fragmento según corresponda
                else -> HomeFragment()
            }

            // Reemplazar el fragmento
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, selectedFragment)
                .commit()

            true
        }

    }
}