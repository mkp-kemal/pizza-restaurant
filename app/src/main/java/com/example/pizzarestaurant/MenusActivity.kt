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
    val EXTRA_PRICE = "com.example.android.twoactivities.extra.PRICE"
    val EXTRA_TITLE = "com.example.android.twoactivities.extra.TITLE"
    val EXTRA_IMG = "com.example.android.twoactivities.extra.IMG"
    val EXTRA_DESCRIPTION = "com.example.android.twoactivities.extra.DESCRIPTION"

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

        val description_menu = listOf(
            "Pizza adalah hidangan yang berasal dari Italia yang telah meraih popularitas global dan menjadi salah satu makanan cepat saji yang paling dicintai di seluruh dunia. Hidangan ini terdiri dari adonan tipis yang biasanya terbuat dari tepung gandum, air, ragi, garam, dan minyak zaitun yang diberi berbagai topping yang beragam. Pizza dihias dengan berbagai bahan seperti saus tomat, keju, sayuran, daging, dan bumbu lainnya.",
            "Spaghetti adalah salah satu hidangan yang sangat populer di seluruh dunia, dan merupakan makanan pokok dalam masakan Italia. Hidangan ini terdiri dari helai-helai pasta panjang dan tipis yang biasanya dibuat dari tepung gandum dan air. Pasta ini kemudian dimasak hingga matang dan sering disajikan dengan berbagai jenis saus, termasuk saus tomat, saus daging, saus krim, dan banyak variasi lainnya.",
            "Burger adalah hidangan populer yang terdiri dari gumpalan daging yang dibakar atau digoreng dan ditempatkan di antara dua irisan roti bundar atau lonjong yang biasanya disebut sebagai \"bun\". Ini adalah makanan yang sangat serbaguna yang dapat disesuaikan dengan berbagai cara, tergantung pada selera individu.",
            "Steak adalah hidangan daging yang telah dipotong tipis dari bagian-bagian yang paling lezat dan berharga dari hewan, seperti sapi, domba, babi, atau ayam. Hidangan ini sering dianggap sebagai makanan yang istimewa dan populer di seluruh dunia. "
        )

        val price = listOf(
            "Rp 80.000.00",
            "Rp 30.000.00",
            "Rp 50.000.00",
            "Rp 90.000.00",
        )

        val image = listOf(
            R.drawable.pizza,
            R.drawable.spaghetti,
            R.drawable.burger,
            R.drawable.steak,
        )

//            Log.d("image", image.toString())

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
        val loopLimit = minOf(title.size, description.size, image.size)

        for (i in 0 until loopLimit) {
            data.add(ItemsViewModel(title[i], description[i], image[i], price[i], description_menu[i]))
        }

        // Menginisialisasi Adapter dengan data ArrayList
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        Log.d("jumlah menu", "Jumlah data: " + data.size)
        val dataList = title // Gantilah yourDataList dengan list yang sesuai
//        for (data in dataList) {
//            Log.d("data menu", "Isi data: ${data}")
//        }

        // Atur OnClickListener pada item-item RecyclerView
        adapter.setOnItemClickListener { position ->
            val selectedItem = data[position]
//            Log.d("data menu", "Isi data: " + selectedItem.title_menu)
            val title = selectedItem.title_menu
            val price = selectedItem.price_menus
            val img = selectedItem.img_menus
            val desc_menu = selectedItem.description_menus2
            val intent = Intent(this, DetailMenus::class.java)
            intent.putExtra(EXTRA_TITLE, title)
            intent.putExtra(EXTRA_PRICE, price)
            intent.putExtra(EXTRA_IMG, img)
            intent.putExtra(EXTRA_DESCRIPTION, desc_menu)
            Log.d("imgmenu", selectedItem.img_menus.toString())
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            startActivity(intent)
        }
    }
}