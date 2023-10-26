package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.PackageManagerCompat.LOG_TAG

class MainActivity : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Mendapatkan Spinner berdasarkan ID
        val spinner = findViewById<Spinner>(R.id.spinner)
        val dropdownItems = resources.getStringArray(R.array.dropdown_items)
        val itemsAsString = dropdownItems.joinToString(", ")
        var selectedText = dropdownItems[0]

        // Mengatur Listener untuk Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                // Saat pilihan diubah, update selectedText
                selectedText = dropdownItems[position]
                Log.d("test array", selectedText)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        Log.d("test array", selectedText)



        val name = findViewById<EditText>(R.id.name)
        val submit = findViewById<Button>(R.id.submit)

        submit?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ShopDetail::class.java)
            val message = name?.text.toString()
//            Log.d(LOG_TAG, message)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, selectedText)
            startActivityForResult(intent, TEXT_REQUEST);
        })

    }
}