package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class ShopDetail : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val seeMenus = findViewById<Button>(R.id.see_menus)

        val intent2 = intent
        val message2 = intent2.getStringExtra(EXTRA_MESSAGE_STORE)
        val textView2 = findViewById<TextView>(R.id.store)
        textView2.text = message2
        if (message2 != null) {
            Log.d("test string", message2)
        }

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.tv_name_navbar)
        textView.text = message


        seeMenus.setOnClickListener {
            val intent = Intent(this, MenusActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            startActivity(intent)
        }
    }
}