package com.example.m3design_uns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
class ScholarshipAdapter(private val scholarships: List<Scholarship>) :
    RecyclerView.Adapter<ScholarshipAdapter.ScholarshipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScholarshipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beca, parent, false)
        return ScholarshipViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScholarshipViewHolder, position: Int) {
        val scholarship = scholarships[position]
        holder.bind(scholarship)
    }

    override fun getItemCount(): Int = scholarships.size

    class ScholarshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.tv_beca_title)
        private val provider: TextView = itemView.findViewById(R.id.tv_beca_provider)
        private val eligibility: TextView = itemView.findViewById(R.id.tv_beca_eligibility)
        private val deadline: TextView = itemView.findViewById(R.id.tv_beca_deadline)
        private val detailsButton: MaterialButton = itemView.findViewById(R.id.btn_ver_detalles)

        fun bind(scholarship: Scholarship) {
            title.text = scholarship.title
            provider.text = scholarship.provider
            eligibility.text = scholarship.eligibility
            deadline.text = "Fecha límite: ${scholarship.deadline}"
        }
    }
}
