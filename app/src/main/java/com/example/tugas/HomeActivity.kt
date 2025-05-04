package com.example.tugas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.MultiAutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.overflowIcon?.setTint(getColor(R.color.white))
        binding.toolbar.navigationIcon?.setTint(getColor(R.color.white))

        val buttonShare = findViewById<Button>(R.id.button3)
        val textInput = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)


        buttonShare.setOnClickListener {
            val textToShare = textInput.text.toString()

            if (textToShare.isNotEmpty()) {
                val intentSendTo = Intent(Intent.ACTION_SEND)
                intentSendTo.putExtra(Intent.EXTRA_TEXT, textToShare)
                intentSendTo.type = "text/plain"

                startActivity(Intent.createChooser(intentSendTo, "Share To"))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){

            R.id.item->{
                startActivity(Intent(this,ProfileActivity::class.java))
                return true
            }

            R.id.item2->{
                startActivity(Intent(this,MainActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
