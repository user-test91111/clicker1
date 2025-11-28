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
    @SuppressLint("MissingInflatedId", "UnsafeIntentLaunch", "SuspiciousIndentation")
    var count = 0
    var multiple = 1
    val bundle = intent.extras
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        if (bundle?.getInt("count")!=null) {
            count = bundle.getInt("count")
        }
        if (bundle?.getInt("multiple")!=null) {
            multiple = bundle.getInt("multiple")
        }

        val textCount = findViewById<TextView>(R.id.clicks)
        val clickButton = findViewById<Button>(R.id.clickbutton)
        clickButton.setOnClickListener {
            count += Plus(multiple)
            textCount.setText(count.toString()) }

        val shopButton = findViewById<Button>(R.id.shopButton)
        val intent = Intent(this, ShopActivity::class.java)
                shopButton.setOnClickListener{
                    intent.putExtra("count", count)
                    intent.putExtra("multiple", multiple)
                startActivity(intent)
            }
        val achButton = findViewById<Button>(R.id.button3)
        val intent2 = Intent(this, AchActivity::class.java)
        achButton.setOnClickListener{
            startActivity(intent2)
        }

    }

    override fun onResume() {
        super.onResume()
        if (bundle?.getInt("count")!=null) {
            count = bundle.getInt("count")
        }
        if (bundle?.getInt("multiple")!=null) {
            multiple = bundle.getInt("multiple")
        }

    }
    fun Plus(multiple: Int): Int{
        return 1*multiple
    }
}