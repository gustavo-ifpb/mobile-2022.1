package br.edu.ifpb.example.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifpb.example.data.Student
import br.edu.ifpb.example.databinding.ActivitySecondBinding
import br.edu.ifpb.example.ui.NameAdapter.ItemClickListener

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val students = arrayOf(
        Student("Gustavo Vieira", "gustavo.vieira@ifpb.edu.br"),
        Student("Cleonice dos Santos", "soares.cleonice@academico.ifpb.edu.br"),
        Student("Daniel Cordeiro", "daniel.cordeiro@academico.ifpb.edu.br"),
        Student("Joyce da Silva", "pinheiro.joyce@academico.ifpb.edu.br"),
        Student("Thiágo Silva", "thiago.morais@academico.ifpb.edu.br"),
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
            students,
            object : ItemClickListener {
                override fun onClick(student: Student) {
                    Toast.makeText(this@SecondActivity, student.name, Toast.LENGTH_LONG).show()
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
