package com.example.m3design_uns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class BecasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScholarshipAdapter
    private lateinit var searchEditText: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_becas, container, false)

        // Inicialización de vistas
        recyclerView = view.findViewById(R.id.scholarshipsRecyclerView)
        searchEditText = view.findViewById(R.id.searchEditText)

        // Lista de becas
        val scholarships = listOf(
            Scholarship(
                id = 1,
                title = "Beca 18",
                provider = "PRONABEC",
                deadline = "2024-03-31",
                eligibility = "Estudiantes de bajos recursos con alto rendimiento académico",
                type = "Completa"
            ),
            Scholarship(
                id = 2,
                title = "Beca de Excelencia Académica UNS",
                provider = "Universidad Nacional del Santa",
                deadline = "2024-04-15",
                eligibility = "Estudiantes con promedio ponderado superior a 16",
                type = "Parcial"
            ),
            Scholarship(
                id = 3,
                title = "Beca de Investigación",
                provider = "Consejo Nacional de Ciencia y Tecnología",
                deadline = "2024-05-30",
                eligibility = "Estudiantes de últimos años con proyecto de investigación",
                type = "Completa"
            )
        )

        // Configuración del RecyclerView
        adapter = ScholarshipAdapter(scholarships)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }
}
