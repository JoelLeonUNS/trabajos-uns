package com.example.m3design_uns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class BecaDetalleFragment : Fragment() {

    private var beca: Scholarship? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beca_detalle, container, false)

        arguments?.let {
            beca = it.getSerializable("beca") as Scholarship
        }

        val title: TextView = view.findViewById(R.id.beca_title)
        val provider: TextView = view.findViewById(R.id.beca_provider)
        val deadline: TextView = view.findViewById(R.id.beca_deadline)
        val eligibility: TextView = view.findViewById(R.id.beca_eligibility)

        beca?.let {
            title.text = it.title
            provider.text = it.provider
            deadline.text = "Fecha límite de postulación: ${it.deadline}"
            eligibility.text = "Elegibilidad: ${it.eligibility}"
        }

        val benefitsLayout: LinearLayout = view.findViewById(R.id.benefits_layout)
        val requirementsLayout: LinearLayout = view.findViewById(R.id.requirements_layout)
        val applicationProcessLayout: LinearLayout = view.findViewById(R.id.application_process_layout)

        beca?.let {
            populateList(benefitsLayout, it.benefits)
            populateList(requirementsLayout, it.requirements)
            populateList(applicationProcessLayout, it.applicationProcess)
        }

        val applyButton: MaterialButton = view.findViewById(R.id.button_apply)
        applyButton.setOnClickListener {
            // Lógica para la postulación
        }

        return view
    }

    private fun populateList(layout: LinearLayout, items: List<String>) {
        for (item in items) {
            val textView = MaterialTextView(requireContext())
            textView.text = "• $item"
            textView.setTextColor(requireContext().getColor(R.color.colorOnSurface))
            textView.textSize = 16f
            layout.addView(textView)
        }
    }
}
