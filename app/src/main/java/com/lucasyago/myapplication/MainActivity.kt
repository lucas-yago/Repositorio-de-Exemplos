package com.lucasyago.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lucasyago.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonLogin.setOnClickListener(this)
        setObserver()
    }

    private fun setObserver() {
        viewModel.welcome().observe(this) {
            binding.textWelcome.text = it
        }
        viewModel.login().observe(this) {
            if (it) {
                Toast.makeText(applicationContext, "SUCESSO!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "FALHA!", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.button_login) {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            viewModel.doLogin(email, password)
        }

    }
}
