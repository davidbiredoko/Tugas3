package com.example.tugas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    private lateinit var mobilRecyclerView: RecyclerView
    private lateinit var mobilAdapter: MyAdapter
    private lateinit var listMobil : ArrayList<ItemData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mobilRecyclerView = findViewById(R.id.mobilRV)
        listMobil = ArrayList()

        listMobil.add(ItemData(R.drawable.r34, name = "Nissan GT R34", color = "Black"))
        listMobil.add(ItemData(R.drawable.r35, name = "Nissan GT R35", color = "Black"))
        listMobil.add(ItemData(R.drawable.rx7, name = "Mazda RX-7", color = "Black"))
        listMobil.add(ItemData(R.drawable.sylvia, name = "Nissan Sylvia", color = "Black"))
        listMobil.add(ItemData(R.drawable.mk4, name = "Toyota Supra MK4", color = "Black"))
        listMobil.add(ItemData(R.drawable.evo, name = "Mithsubishi Evo", color = "Black"))
        listMobil.add(ItemData(R.drawable.ae86, name = "Toyota AE86", color = "Black & White"))
        listMobil.add(ItemData(R.drawable.civic, name = "Honda Civic Typr-R", color = "Black"))
        listMobil.add(ItemData(R.drawable.e30, name = "BMW E30", color = "Black"))
        listMobil.add(ItemData(R.drawable.urus, name = "Lamborghini Urus", color = "Black"))

        mobilRecyclerView.layoutManager = LinearLayoutManager(this)
        mobilRecyclerView.setHasFixedSize(true)
        mobilAdapter = MyAdapter(listMobil)
        mobilRecyclerView.adapter = mobilAdapter
    }
}