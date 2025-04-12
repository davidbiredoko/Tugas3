package com.example.tugas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val img: ImageView = findViewById(R.id.imageView6)
        val name: TextView = findViewById(R.id.textView3)
        val desc: TextView = findViewById(R.id.textView8)


        val data = intent.getParcelableExtra<ItemData>("item")


        data?.let {
            img.setImageResource(it.img)
            name.text = it.name
            desc.text = it.desc
        }
    }
}