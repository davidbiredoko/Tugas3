package com.example.tugas

import android.annotation.SuppressLint
import android.content.Intent
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

        listMobil.add(ItemData(R.drawable.r34, "Nissan GT R34", "Black", "Mobil Nissan Skyline R34 adalah generasi kelima dari seri GT-R yang diproduksi oleh Nissan Motor Co., Ltd. Mobil ini diluncurkan pertama kali pada Januari 1999 dan produksinya berakhir pada Agustus 2002 silam."))
        listMobil.add(ItemData(R.drawable.r35, "Nissan GT R35", "Black", "Nissan GTR R35 merupakan mobil balap legendaris dengan performa serta desain yang mengagumkan. Diperkenalkan pertama kali pada tahun 2007, mobil ini menawarkan kombinasi yang sempurna antara kecepatan, teknologi canggih, serta desain ergonomis yang modern."))
        listMobil.add(ItemData(R.drawable.rx7, "Mazda RX-7", "Black", "RX-7 generasi pertama, terkadang disebut sebagai SA (awal) dan FB (akhir), adalah mobil hatchback coupé dua pintu dengan dua tempat duduk. Mobil ini dilengkapi dengan mesin rotari karburator 12A serta pilihan mesin rotari 13B dengan injeksi bahan bakar elektronik di tahun-tahun berikutnya."))
        listMobil.add(ItemData(R.drawable.sylvia, "Nissan Silvia", "Black", "Nissan Silvia adalah mobil sport kompak berpenggerak roda belakang buatan Nissan Motors, Jepang. Generasi pertama Silvia hanya dibuat dalam jumlah yang sedikit, dalam waktu singkat pada tahun 1960-an. Pada pertengahan tahun 1970-an sampai 2002"))
        listMobil.add(ItemData(R.drawable.mk4, "Toyota Supra MK4", "Black", "Toyota MK4 merupakan mobil sport yang dirilis pada tahun 1990an dan merupakan salah satu mobil ikonik pada masanya dengan banderol harga yang relatif tinggi. Tampilan yang sporty dan mesin yang sangar menjadi salah satu daya tarik utama sehingga mobil ini cukup diminati oleh banyak orang."))
        listMobil.add(ItemData(R.drawable.evo, "Mithsubishi Evo", "Black", "Mitsubishi Evolution, yang populer disebut sebagai 'Evo', adalah sedan sport dan mobil reli berdasarkan Lancer yang diproduksi oleh pabrikan Jepang Mitsubishi Motors dari tahun 1992 hingga 2016"))
        listMobil.add(ItemData(R.drawable.ae86, "Toyota AE86", "Black & White", "AE86 memiliki desain yang lebih aerodinamis dan sporty dibandingkan dengan pendahulunya. Mesinnya Dilengkapi dengan mesin 1.6L DOHC 4A-GE yang menghasilkan 130 HP dan 1.6L SOHC 4A-C yang menghasilkan 90 HP. Transmisinya Tersedia transmisi manual 5-percepatan dan otomatis 4-percepatan."))
        listMobil.add(ItemData(R.drawable.civic, "Honda Civic Typr-R", "Black", "Versi Type R dari Civic biasanya memiliki bodi yang lebih ringan dan lebih kaku, mesin yang disetel secara khusus, serta rem dan sasis yang ditingkatkan, dan hanya ditawarkan dalam transmisi manual lima atau enam kecepatan . Seperti model Type R lainnya, warna merah digunakan di latar belakang emblem Honda untuk membedakannya dari model lain."))
        listMobil.add(ItemData(R.drawable.e30, "BMW E30", "Black", "E30 secara luas diterima sebagai salah satu mobil dengan performa terbaik di eranya. Dengan distribusi bobot yang hampir sempurna, suspensi yang disetel dengan baik, dan pengaturan penggerak roda belakang , mobil ini dapat dikendalikan dengan baik saat menikung."))
        listMobil.add(ItemData(R.drawable.urus, "Lamborghini Urus", "Black", "Lamborghini Urus 2025 adalah 5 seater SUV. Ini tersedia dalam 6 warna, 3 varian, 1 pilihan mesin, dan 1 opsi transmisi: Otomatis di Indonesia. Dimensi Urus adalah 5137 mm L x 2181 mm W x 1618 mm H. Pesaing terdekat Lamborghini Urus adalah Fortuner, X Trail, CX-30 dan 3008."))

        mobilRecyclerView.layoutManager = LinearLayoutManager(this)
        mobilRecyclerView.setHasFixedSize(true)
        mobilAdapter = MyAdapter(listMobil)
        mobilRecyclerView.adapter = mobilAdapter

        mobilAdapter.onItemClick = { selectedItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", selectedItem)
            startActivity(intent)
        }
    }
}