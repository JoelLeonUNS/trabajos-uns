package com.example.m3design_uns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cardHomeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Define las secciones que quieres mostrar
        val cards = listOf(
            CardHome("announcements", "Anuncios Oficiales", "Últimos anuncios y comunicados oficiales de la universidad.", R.drawable.campaign_24px),
            CardHome("scholarships", "Becas", "Información sobre becas disponibles y procesos de postulación.", R.drawable.featured_seasonal_and_gifts_24px),
            CardHome("contests", "Concursos UNS", "Concursos académicos y oportunidades de participación.", R.drawable.dock_to_bottom_24px),
            CardHome("training", "Capacitaciones", "Programas de capacitación y desarrollo profesional.", R.drawable.group_24px),
            CardHome("community", "Comunidad EPISI", "Espacio dedicado a la comunidad de estudiantes.", R.drawable.meeting_24px)
        )

        val adapter = CardHomeAdapter(cards)
        recyclerView.adapter = adapter

        return view
    }
}