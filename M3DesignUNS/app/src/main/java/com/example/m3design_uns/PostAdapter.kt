package com.example.m3design_uns

// PostAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    private val posts: List<Post>,
    private val onClick: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val author: TextView = itemView.findViewById(R.id.tvAuthorName)
        private val date: TextView = itemView.findViewById(R.id.tvPostDate)
        private val content: TextView = itemView.findViewById(R.id.tvPostContent)
        private val likes: TextView = itemView.findViewById(R.id.btnLike)
        private val comments: TextView = itemView.findViewById(R.id.btnComment)

        fun bind(post: Post) {
            author.text = post.author
            date.text = post.date
            content.text = post.content
            likes.text = "${post.likes} Me gusta"
            comments.text = "${post.comments} Comentarios"

            itemView.setOnClickListener {
                onClick(post)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comunidad, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size
}
