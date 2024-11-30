package com.example.mysea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReportAdapter(private val reports: List<Triple<String, String, String>>) :
    RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    // ViewHolder para cada item
    class ReportViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUser: TextView = view.findViewById(R.id.tvUser)
        val tvActivity: TextView = view.findViewById(R.id.tvActivity)
        val tvLocation: TextView = view.findViewById(R.id.tvLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_report, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report = reports[position]
        holder.tvUser.text = report.first
        holder.tvActivity.text = report.second
        holder.tvLocation.text = report.third
    }

    override fun getItemCount(): Int = reports.size
}