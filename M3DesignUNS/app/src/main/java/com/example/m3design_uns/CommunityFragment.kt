import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.button.MaterialButton
import android.widget.TextView
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.m3design_uns.CommunityAdapter
import com.example.m3design_uns.Post
import com.example.m3design_uns.R
import com.google.android.material.search.SearchBar

class CommunityFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CommunityAdapter

    private val posts = listOf(
        Post(
            1,
            "Ana García",
            "placeholder_avatar",
            "2024-02-15",
            "¿Alguien tiene los apuntes de la clase de Estructuras de Datos del profesor Martínez?",
            5,
            3
        ),
        Post(
            2,
            "Carlos Rodríguez",
            "placeholder_avatar",
            "2024-02-14",
            "Recordatorio: Mañana es la presentación de proyectos de Ingeniería de Software. ¡Buena suerte a todos!",
            12,
            7
        ),
        Post(
            3,
            "María López",
            "placeholder_avatar",
            "2024-02-13",
            "Estoy organizando un grupo de estudio para el examen de Redes. ¿Quién se apunta?",
            8,
            15
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSearchBar(view)
        setupNewPostCard(view)
        setupRecyclerView(view)
    }

    private fun setupSearchBar(view: View) {
        val searchBar = view.findViewById<SearchBar>(R.id.searchBar)
        searchBar.hint = "Buscar en la comunidad..."
    }

    private fun setupNewPostCard(view: View) {
        val postInput = view.findViewById<TextInputEditText>(R.id.postInput)
        val publishButton = view.findViewById<MaterialButton>(R.id.publishButton)

        publishButton.setOnClickListener {
            // Handle post publication
        }
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.postsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CommunityAdapter(posts)
        recyclerView.adapter = adapter
    }
}