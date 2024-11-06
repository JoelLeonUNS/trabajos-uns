package com.example.m3design_uns

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DetalleCapacitacionFragment : Fragment(R.layout.fragment_capacitacion_detalle) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Accede a los elementos del XML
        val btnVolver: Button = view.findViewById(R.id.btnVolver)
        val txtTituloCapacitacion: TextView = view.findViewById(R.id.txtTituloCapacitacion)
        val txtInstructor: TextView = view.findViewById(R.id.txtInstructor)
        val txtFecha: TextView = view.findViewById(R.id.txtFecha)
        val txtDuracion: TextView = view.findViewById(R.id.txtDuracion)
        val btnInscribirse: Button = view.findViewById(R.id.btnInscribirse)

        // Configura el texto y los eventos
        txtTituloCapacitacion.text = "Nueva Capacitación"
        txtInstructor.text = "Instructor: Dra. Ana Pérez"
        txtFecha.text = "Inicio: 2024-05-01"
        txtDuracion.text = "Duración: 30 horas"

        // Acción para el botón Volver
        btnVolver.setOnClickListener {
            // Acción cuando se presiona el botón Volver
            activity?.onBackPressed()  // Vuelve atrás (o puedes manejarlo de otra forma)
        }

        // Acción para el botón Inscribirse
        btnInscribirse.setOnClickListener {
            // Acción cuando se presiona el botón Inscribirse
            Toast.makeText(requireContext(), "Te has inscrito en la capacitación", Toast.LENGTH_SHORT).show()
        }
    }
}

