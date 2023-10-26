package com.example.pizzarestaurant

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.WindowManager
import android.widget.TextView

class OrderDetail : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE) ?: "NilaiDefault"
        val textView_name = findViewById<TextView>(R.id.order_name)
        textView_name.text = message

        val intent2 = intent
        val message2 = intent2.getStringExtra(EXTRA_MESSAGE_STORE)
        val textView2 = findViewById<TextView>(R.id.order_store)
        textView2.text = message2

        val kalimat = "Terima kasih $message sudah memesan di toko kami, pesanan Pepperoni Pizza anda dikirim menggunakan Fast Delivery"

        val spannableString = SpannableString(kalimat)
        val startIndex = kalimat.indexOf(message)
        val endIndex = startIndex + message.length

        spannableString.setSpan(ForegroundColorSpan(Color.RED), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val textView = findViewById<TextView>(R.id.letter_done)
        textView.text = spannableString

    }
}