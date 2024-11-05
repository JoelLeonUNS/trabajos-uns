package com.example.m3design_uns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnnouncementAdapter (private val announcements: List<Announcement>):
    RecyclerView.Adapter<AnnouncementAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anuncio, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = announcements[position]
        holder.bind(section)
    }

    override fun getItemCount() = announcements.size

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.tv_anuncio_title)
        private val date: TextView = itemView.findViewById(R.id.tv_anuncio_date)
        private val content: TextView = itemView.findViewById(R.id.tv_anuncio_content)
        private val btnViewMore: Button = itemView.findViewById(R.id.btn_read_more)

        fun bind(announcement: Announcement) {
            title.text = announcement.title
            date.text = announcement.date
            content.text = announcement.content
            btnViewMore.setOnClickListener {
                //Lógica
            }
        }
    }
}