package com.example.m3design_uns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CardHomeAdapter (private val cards: List<CardHome>):
    RecyclerView.Adapter<CardHomeAdapter.SectionViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
            return SectionViewHolder(view)
        }

        override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
            val section = cards[position]
            holder.bind(section)
        }

        override fun getItemCount() = cards.size

        inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val title: TextView = itemView.findViewById(R.id.tv_card_home_title)
            private val content: TextView = itemView.findViewById(R.id.tv_card_home_content)
            private val icon: ImageView = itemView.findViewById(R.id.iv_card_home_image)
            private val btnViewMore: Button = itemView.findViewById(R.id.btn_ver_mas)
            private val cardView: CardView = itemView.findViewById(R.id.card_home)

            fun bind(card: CardHome) {
                title.text = card.title
                content.text = card.content
                icon.setImageResource(card.iconResId)
                cardView.setCardBackgroundColor(card.color)
                btnViewMore.setOnClickListener {
                    //Lógica
                }
            }
        }
}
