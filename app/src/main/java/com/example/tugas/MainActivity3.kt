package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas.databinding.ActivityMain3Binding
import com.google.firebase.auth.FirebaseAuth


class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main3)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView6.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.button.setOnClickListener{
            val email: String = binding.edtEmail2.text.toString().trim()
            if (email.isEmpty()){
                binding.edtEmail2.error = "Input Email"
                binding.edtEmail2.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmail2.error = "Invalid Email"
                binding.edtEmail2.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { it ->
                if (it.isSuccessful) {
                    Toast.makeText(this, "cek email for reset password", Toast.LENGTH_SHORT).show()
                    Intent(this, MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }

                else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}