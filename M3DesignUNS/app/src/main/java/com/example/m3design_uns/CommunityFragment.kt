import com.example.m3design_uns.Post
import com.example.m3design_uns.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m3design_uns.PostAdapter
import com.google.android.material.button.MaterialButton

class CommunityFragment : Fragment() {

    private lateinit var postAdapter: PostAdapter
    private lateinit var rvPosts: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_community, container, false)

        rvPosts = view.findViewById(R.id.rvPosts)
        val btnLoadMorePosts: MaterialButton = view.findViewById(R.id.btnLoadMorePosts)

        // Inicializar la lista de publicaciones (puedes reemplazar esto con datos reales)
        val posts = listOf(
            Post("Ana García", "2024-02-15", "¿Alguien tiene los apuntes de Estructuras de Datos?", 15, 3),
            Post("Luis Pérez", "2024-02-14", "Recomendaciones para estudiar Java", 10, 5)
        )

        // Configurar RecyclerView y Adapter
        postAdapter = PostAdapter(posts) { post ->
            // Manejo del click en una publicación
            Toast.makeText(requireContext(), "Seleccionado: ${post.author}", Toast.LENGTH_SHORT).show()
            // Navegación a PostDetailFragment o lógica que necesites
        }
        rvPosts.layoutManager = LinearLayoutManager(requireContext())
        rvPosts.adapter = postAdapter

        // Cargar más publicaciones al hacer click
        btnLoadMorePosts.setOnClickListener {
            Toast.makeText(requireContext(), "Cargando más publicaciones...", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
