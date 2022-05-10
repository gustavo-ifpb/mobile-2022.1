package br.edu.ifpb.example

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
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

    private fun showToast() {
        Toast.makeText(this, binding.etEmail.text, Toast.LENGTH_LONG).show()
    }
}
