package com.example.m3design_uns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CommentAdapter(private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorAvatar: ShapeableImageView = itemView.findViewById(R.id.commentAuthorAvatar)
        val authorName: TextView = itemView.findViewById(R.id.commentAuthorName)
        val date: TextView = itemView.findViewById(R.id.commentDate)
        val content: TextView = itemView.findViewById(R.id.commentContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]

        holder.authorName.text = comment.author
        holder.date.text = comment.date
        holder.content.text = comment.content
        // Set avatar image (placeholder for now)
        holder.authorAvatar.setImageResource(R.drawable.account_circle_24px)
    }

    override fun getItemCount() = comments.size
}