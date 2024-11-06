package com.example.m3design_uns

// PostDetailFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PostDetailFragment : Fragment() {

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var rvComments: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post_detail, container, false)

        rvComments = view.findViewById(R.id.rvComments)

        // Inicializar lista de comentarios (puedes reemplazar con datos reales)
        val comments = listOf(
            Comment("María López", "¡Gracias por compartir!"),
            Comment("Juan Pérez", "Me interesa también.")
        )

        // Configurar RecyclerView y Adapter para comentarios
        commentAdapter = CommentAdapter(comments)
        rvComments.layoutManager = LinearLayoutManager(requireContext())
        rvComments.adapter = commentAdapter

        return view
    }
}
