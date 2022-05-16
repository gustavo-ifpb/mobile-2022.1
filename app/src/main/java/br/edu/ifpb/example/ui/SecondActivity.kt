package br.edu.ifpb.example.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifpb.example.databinding.ActivitySecondBinding
import br.edu.ifpb.example.ui.NameAdapter.ItemClickListener

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val names = listOf(
        "Gustavo Vieira",
        "Cleonice dos Santos Barbosa Soares",
        "Daniel Cordeiro da Costa",
        "Joyce da Silva Pinheiro",
        "Gustavo Vieira",
        "Cleonice dos Santos Barbosa Soares",
        "Daniel Cordeiro da Costa",
        "Joyce da Silva Pinheiro",
        "Gustavo Vieira",
        "Cleonice dos Santos Barbosa Soares",
        "Daniel Cordeiro da Costa",
        "Joyce da Silva Pinheiro",
        "Gustavo Vieira",
        "Cleonice dos Santos Barbosa Soares",
        "Daniel Cordeiro da Costa",
        "Joyce da Silva Pinheiro",
        "Thiágo Silva de Morais",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = NameAdapter(
            names,
            object : ItemClickListener {
                override fun onClick(name: String) {
                    Toast.makeText(this@SecondActivity, name, Toast.LENGTH_LONG).show()
                }
            }
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PASSWORD = "extra_password"
    }
}
