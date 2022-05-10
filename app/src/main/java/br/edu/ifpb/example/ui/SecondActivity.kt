package br.edu.ifpb.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifpb.example.databinding.ActivitySecondBinding

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
        val adapter = NameAdapter(names)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = GridLayoutManager(this, 5)
    }

    companion object {
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PASSWORD = "extra_password"
    }
}
