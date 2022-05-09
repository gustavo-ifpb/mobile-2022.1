package br.edu.ifpb.example.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.edu.ifpb.example.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.extras?.getString(EXTRA_EMAIL)
        binding.title.text = email

        val password = intent.extras?.getString(EXTRA_PASSWORD)
        binding.description.text = password
    }

    companion object {
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PASSWORD = "extra_password"
    }
}
