package br.edu.ifpb.example

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifpb.example.databinding.ActivityMainBinding
import br.edu.ifpb.example.ui.SecondActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        setupSigninButton()
        setupPasswordClick()
        setupSpinner()
    }

    private fun setupSigninButton() {
        binding.btnSignin.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.EXTRA_EMAIL, binding.etEmail.text.toString())
            intent.putExtra(SecondActivity.EXTRA_PASSWORD, binding.etPassword.text.toString())

            startActivity(intent)
        }
    }

    private fun setupPasswordClick() {
        binding.etPassword.setOnEditorActionListener { textView, i, keyEvent ->
            when (i) {
                EditorInfo.IME_ACTION_GO -> {
                    showToast()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupSpinner() {
        ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item)
            .also {
                it.setDropDownViewResource(R.layout.spinner_view)
                binding.spOptions.adapter = it
            }
        binding.spOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                val data = resources.getStringArray(R.array.planets_array)
                if (pos == data.size - 1) {
                    Toast.makeText(this@MainActivity, "Outro!", Toast.LENGTH_LONG).show()
                    binding.etEmail.visibility = View.VISIBLE
                    binding.etEmail.requestFocus()
                } else {
                    binding.etEmail.visibility = View.GONE
                    Toast.makeText(this@MainActivity, parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun showToast() {
        Toast.makeText(this, binding.etEmail.text, Toast.LENGTH_LONG).show()
    }
}
