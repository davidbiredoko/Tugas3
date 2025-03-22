package com.example.tugas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView5.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.button.setOnClickListener{
                startActivity(Intent(this, MainActivity::class.java))
        }

        binding.textView3.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}