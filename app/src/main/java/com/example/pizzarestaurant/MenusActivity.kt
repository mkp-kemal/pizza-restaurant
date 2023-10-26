package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenusActivity : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.tv_name_navbar_act_menus)
        textView.text = message

        val intent2 = intent
        val message2 = intent2.getStringExtra(EXTRA_MESSAGE_STORE)

        // Mengganti array string menjadi ArrayList
        val title = listOf(
            "Paperoni Pizza",
            "Spaghetti",
            "Burger",
            "Steak"
        )
        val description = listOf(
            "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat",
            "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental",
            "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal",
            "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat"
        )

        // Mendapatkan recyclerview berdasarkan ID
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

//        recyclerview.setOnClickListener {
//            val intent = Intent(this, DetailMenus::class.java)
//            startActivity(intent)
//        }

        // Membuat objek LayoutManager untuk tata letak vertikal
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager

        // Membuat ArrayList dari class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // Memastikan untuk menghindari indeks out of range dengan batas loop yang sesuai
        val loopLimit = minOf(title.size, description.size)

        for (i in 0 until loopLimit) {
            data.add(ItemsViewModel(title[i], description[i]))
        }

        // Menginisialisasi Adapter dengan data ArrayList
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

//        Log.d("test string", "Jumlah data: " + data.size)

        // Atur OnClickListener pada item-item RecyclerView
        adapter.setOnItemClickListener { position ->
            val intent = Intent(this, DetailMenus::class.java)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            startActivity(intent)
        }
    }
}