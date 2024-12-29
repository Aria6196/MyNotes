package proyek.pam.mynotes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import proyek.pam.mynotes.database.NoteDatabase
import proyek.pam.mynotes.repository.NoteRepository
import proyek.pam.mynotes.viewmodel.NoteViewModel
import proyek.pam.mynotes.viewmodel.NoteViewModelFactory
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menambahkan Toolbar ke ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Setup ViewModel
        setupViewModel()
    }

    private fun setupViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }

    // Inflasi menu dan menampilkan SearchView
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    // Menangani klik item menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.searchMenu -> {
                // Logika pencarian bisa ditambahkan di sini
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
