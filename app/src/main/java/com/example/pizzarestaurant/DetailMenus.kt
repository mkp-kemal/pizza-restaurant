package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class DetailMenus : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menus)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val intent2 = intent
        val message2 = intent2.getStringExtra(EXTRA_MESSAGE_STORE)

        val btn_back = findViewById<Button>(R.id.btn_back)
        val btn_order = findViewById<Button>(R.id.btn_order)

        btn_back.setOnClickListener {
            onBackPressed()
        }

        btn_order.setOnClickListener {
            val intent = Intent(this, OrderDetail::class.java)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            startActivity(intent)
        }
    }
}