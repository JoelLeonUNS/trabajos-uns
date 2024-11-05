package com.example.m3design_uns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class AnuncioDetalleFragment : Fragment() {

    private var announcement: Announcement? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_anuncio_detalle, container, false)

        // Recupera los datos del anuncio
        arguments?.let {
            announcement = it.getSerializable("announcement") as? Announcement
        }

        // Configura los datos en las vistas
        val title: TextView = view.findViewById(R.id.tv_anuncio_detalle_title)
        val date: TextView = view.findViewById(R.id.tv_anuncio_detalle_date)
        val content: TextView = view.findViewById(R.id.tv_anuncio_detalle_content)
        val information: TextView = view.findViewById(R.id.tv_anuncio_detalle_information)

        announcement?.let {
            title.text = it.title
            date.text = "Publicado el ${it.date}"
            content.text = it.content
            information.text = it.information

            // Carga y muestra los detalles en la sección de detalles
            val detailsLayout: LinearLayout = view.findViewById(R.id.details_layout)
            for (detail in it.details) {
                val detailView = LayoutInflater.from(context).inflate(R.layout.item_anuncio_detail, detailsLayout, false)
                val icon: ImageView = detailView.findViewById(R.id.detail_icon)
                val text: TextView = detailView.findViewById(R.id.detail_text)

                icon.setImageResource(detail.iconResId)
                text.text = detail.text

                detailsLayout.addView(detailView)
            }
        }

        // Configurar el botón de retroceso
        val backArrow: ImageView = view.findViewById(R.id.arrow_back)
        backArrow.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }

        return view
    }


}