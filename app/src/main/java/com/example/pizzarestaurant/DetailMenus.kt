package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailMenus : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_TITLE = "com.example.android.twoactivities.extra.TITLE"

    val EXTRA_IMG = "com.example.android.twoactivities.extra.IMG"

    //    val EXTRA_IMG = 0
    val EXTRA_PRICE = "com.example.android.twoactivities.extra.PRICE"
    val EXTRA_DESCRIPTION = "com.example.android.twoactivities.extra.DESCRIPTION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menus)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val title_menu = findViewById<TextView>(R.id.title_menu)
        val price_menu = findViewById<TextView>(R.id.tv_price)
        val img_menu = findViewById<ImageView>(R.id.iv_img)
        val description_menu = findViewById<TextView>(R.id.descr_menu)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val intent2 = intent
        val message2 = intent2.getStringExtra(EXTRA_MESSAGE_STORE)

        val intent3 = intent
        val message3 = intent3.getStringExtra(EXTRA_TITLE)
        title_menu.text = message3
//        if (message3 != null) {
//            Log.d("Title", message3)
//        }

        val intent4 = intent
        val message4 = intent4.getStringExtra(EXTRA_PRICE)
        price_menu.text = ("Price: ${message4}")
//        if (message4 != null) {
//            Log.d("Price", message4)
//        }

        val intent5 = intent
        val message5 = intent5.getStringExtra(EXTRA_IMG)
        val imageResource = message5?.toIntOrNull() // Menggunakan toIntOrNull() agar null-safe

        if (imageResource != null) {
            img_menu.setImageResource(imageResource)
        } else {
            // Jika imageResource null, Anda dapat menetapkan gambar default atau melakukan tindakan lainnya
            img_menu.setImageResource(R.drawable.logo) // Gantilah dengan ID gambar default yang sesuai
        }


//        if (message5 != null) {
//            Log.d("IMG", message5)
//        }

        val intent6 = intent
        val message6 = intent6.getStringExtra(EXTRA_DESCRIPTION)
        description_menu.text = message6
        if (message6 != null) {
            Log.d("DESC", message6)
        }

        val btn_back = findViewById<Button>(R.id.btn_back)
        val btn_order = findViewById<Button>(R.id.btn_order)

        btn_back.setOnClickListener {
            onBackPressed()
        }

        btn_order.setOnClickListener {
            val intent = Intent(this, OrderDetail::class.java)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            intent.putExtra(EXTRA_TITLE, message3)
            startActivity(intent)
        }
    }
}