package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas.databinding.ActivityMain2Binding
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener {
            val email = binding.edtEmail2.text.toString().trim()
            val password = binding.edtPass1.text.toString().trim()
            val confirmPassword = binding.edtConfirmPass.text.toString().trim()

            if (email.isEmpty()) {
                binding.edtEmail2.error = "Masukkan email"
                binding.edtEmail2.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmail2.error = "Format email tidak valid"
                binding.edtEmail2.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.edtPass1.error = "Password minimal 6 karakter"
                binding.edtPass1.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                binding.edtConfirmPass.error = "Password tidak cocok"
                binding.edtConfirmPass.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)
        }

        binding.textView3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.textView5.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Registrasi berhasil!.", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }, 300)
                } else {
                    Toast.makeText(this, it.exception?.message ?: "Registrasi gagal", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
