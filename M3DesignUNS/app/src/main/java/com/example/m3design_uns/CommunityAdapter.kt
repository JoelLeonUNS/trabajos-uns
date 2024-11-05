package com.example.m3design_uns

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView

class CommunityAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<CommunityAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorAvatar: ShapeableImageView = itemView.findViewById(R.id.authorAvatar)
        val authorName: TextView = itemView.findViewById(R.id.authorName)
        val postDate: TextView = itemView.findViewById(R.id.postDate)
        val postContent: TextView = itemView.findViewById(R.id.postContent)
        val likeButton: MaterialButton = itemView.findViewById(R.id.likeButton)
        val commentButton: MaterialButton = itemView.findViewById(R.id.commentButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comunidad, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        holder.authorName.text = post.author
        holder.postDate.text = post.date
        holder.postContent.text = post.content
        holder.likeButton.text = "${post.likes}"
        holder.commentButton.text = "${post.comments}"

        // Set click listeners
        holder.likeButton.setOnClickListener {
            // Handle like action
        }

        holder.commentButton.setOnClickListener {
            // Handle comment action
        }
    }

    override fun getItemCount() = posts.size
}