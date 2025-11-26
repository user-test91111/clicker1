package com.example.clicker1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "UnsafeIntentLaunch")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var count = 0
        var multiple = 1
        val costx2 = 100
        val costx10 = 500
        val costx100 = 1000
        val textCount = findViewById<TextView>(R.id.clicks)
        val clickButton = findViewById<Button>(R.id.clickbutton)
        clickButton.setOnClickListener {
            count += Plus(multiple)
            textCount.setText(count.toString()) }

        val shopButton = findViewById<Button>(R.id.shopButton)
        val intent = Intent(this, ShopActivity::class.java)
                shopButton.setOnClickListener{
                startActivity(intent)
            }

    }
    fun Plus(multiple: Int): Int{
        return 1*multiple
    }
}