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

class ShopActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<Button>(R.id.button10)
        backButton.setOnClickListener{
            finish()
        }

        val achButton = findViewById<Button>(R.id.button11)
        val intent2 = Intent(this, AchActivity::class.java)
        achButton.setOnClickListener{
            startActivity(intent2)
        }

        var count = 0
        var multiple = 1
        val costx2 = 100
        val costx10 = 500
        val costx100 = 1000
        val costFarm1 = 75
        val costFarm2 = 150
        val costFarm3 = 650
        val textCount = findViewById<TextView>(R.id.count)
        textCount.setText(count.toString())

        val x2Button = findViewById<Button>(R.id.button)
        x2Button.setOnClickListener {
            if (count >= costx2){
                count -= costx2
                multiple = 2
            }
        }

        val x10Button = findViewById<Button>(R.id.button5)
        x10Button.setOnClickListener {
            if (count >= costx10){
                count -= costx10
                multiple = 10
            }
        }

        val x100Button = findViewById<Button>(R.id.button6)
        x100Button.setOnClickListener {
            if (count >= costx100){
                count -= costx100
                multiple = 100
            }
        }
    }
}