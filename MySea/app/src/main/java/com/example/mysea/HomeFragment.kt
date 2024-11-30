package com.example.mysea
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Datos de ejemplo
        val userReports = listOf(
            Triple("María G.", "Pesca ilegal", "Bahía de San Juan"),
            Triple("Carlos R.", "Vertido de residuos", "Playa del Carmen"),
            Triple("Ana L.", "Caza de especies protegidas", "Isla del Coco")
        )

        // Configurar RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerReports)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ReportAdapter(userReports)

        return view
    }
}