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
            Announcement("1",
                "Inicio de matrícula para el semestre 2024-I",
                "2024-02-15",
                "Se informa a todos los estudiantes que el proceso de matrícula para el semestre 2024-I comenzará el 1 de marzo. Por favor, revisen sus horarios y requisitos en el portal estudiantil.",
                listOf(
                    AnnouncementDetail(R.drawable.calendar_today_24px,"Fecha de inicio: 1 de marzo, 2024"),
                    AnnouncementDetail(R.drawable.schedule_24px,"Horario: 8:00 AM - 6:00 PM"),
                    AnnouncementDetail(R.drawable.location_on_24px,"Lugar: Portal Estudiantil en línea")
                ),
                "Recuerden tener sus documentos al día y haber completado la encuesta de satisfacción del semestre anterior. Para cualquier consulta, pueden contactar a la Oficina de Registros Académicos."
            ),
            Announcement("2",
                "Convocatoria para proyectos de investigación",
                "2024-02-10",
                "La Universidad Nacional del Santa invita a todos los docentes y estudiantes a participar en la convocatoria anual de proyectos de investigación. Las propuestas se recibirán hasta el 30 de abril.",
                listOf(
                    AnnouncementDetail(R.drawable.calendar_today_24px,"Fecha de inicio: 15 de junio, 2024"),
                    AnnouncementDetail(R.drawable.schedule_24px,"Horario: 8:00 AM - 6:00 PM"),
                ),
                "Recuerden tener sus documentos al día y haber completado la encuesta de satisfacción del semestre anterior. Para cualquier consulta, pueden contactar a la Oficina de Registros Académicos."
            ),
            Announcement("3",
                "Mantenimiento programado del sistema académico",
                "2024-02-05",
                "Se realizará un mantenimiento programado del sistema académico el día 20 de febrero de 8:00 AM a 12:00 PM. Durante este período, el acceso al portal estudiantil estará limitado.",
                listOf(
                    AnnouncementDetail(R.drawable.calendar_today_24px,"Fecha de inicio: 28 de julio, 2024"),
                    AnnouncementDetail(R.drawable.schedule_24px,"Horario: 8:00 AM - 6:00 PM"),
                ),
                "Recuerden tener sus documentos al día y haber completado la encuesta de satisfacción del semestre anterior. Para cualquier consulta, pueden contactar a la Oficina de Registros Académicos."
            ),
        )

        //val adapter = AnnouncementAdapter(anuncios)
        //recyclerView.adapter = adapter

        // Configura el adaptador con el clickListener
        recyclerView.adapter = AnnouncementAdapter(anuncios) { announcement ->
            val fragment = AnuncioDetalleFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("announcement", announcement)
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

}