package com.example.m3design_uns

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnunciosFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_anuncios, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.anunciosRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Define las secciones que quieres mostrar
        val anuncios = listOf(
            Announcement("1", "Inicio de matrícula para el semestre 2024-I", "2024-02-15", "Se informa a todos los estudiantes que el proceso de matrícula para el semestre 2024-I comenzará el 1 de marzo. Por favor, revisen sus horarios y requisitos en el portal estudiantil."),
            Announcement("2", "Convocatoria para proyectos de investigación", "2024-02-10", "La Universidad Nacional del Santa invita a todos los docentes y estudiantes a participar en la convocatoria anual de proyectos de investigación. Las propuestas se recibirán hasta el 30 de abril."),
            Announcement("3", "Mantenimiento programado del sistema académico", "2024-02-05", "Se realizará un mantenimiento programado del sistema académico el día 20 de febrero de 8:00 AM a 12:00 PM. Durante este período, el acceso al portal estudiantil estará limitado."),
        )

        val adapter = AnnouncementAdapter(anuncios)
        recyclerView.adapter = adapter

        return view
    }

}