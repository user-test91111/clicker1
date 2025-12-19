package com.example.clicker1.present

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.clicker1.R
import com.example.clicker1.data.MainViewDataModel
import kotlin.getValue
import kotlin.math.absoluteValue

class ShopActivity : AppCompatActivity() {

    private val mainVM: MainViewDataModel by viewModels()
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

        val textCount = findViewById<TextView>(R.id.count)
        Log.v("F", mainVM.count.toString())
        mainVM.count.observe(this) { count ->
            textCount.text = count.toString()
        }

        val x2Button = findViewById<Button>(R.id.button6)
        x2Button.setOnClickListener {
            if(mainVM.buy(50, 2, mainVM.usedX2)) {
                Log.v("Log", "BUY MOD")

            }
        }

        val x10Button = findViewById<Button>(R.id.button5)
        x10Button.setOnClickListener {
            if(mainVM.buy(200, 10, mainVM.usedX10)) {
                Log.v("Log", "BUY MOD")

            }
        }

        val x100Button = findViewById<Button>(R.id.button)
        x100Button.setOnClickListener {
            if(mainVM.buy(1000, 100, mainVM.usedX100)) {
                Log.v("Log", "BUY MOD")

            }
        }

        val farm1Button = findViewById<Button>(R.id.button7)
        farm1Button.setOnClickListener {
            if(mainVM.farm(5, 75, mainVM.farm1)) {
                Log.v("Log", "BUY FARM")

            }
        }

        val farm2Button = findViewById<Button>(R.id.button8)
        farm2Button.setOnClickListener {
            if(mainVM.farm(20, 150, mainVM.farm2)) {
                Log.v("Log", "BUY FARM")

            }
        }

        val farm3Button = findViewById<Button>(R.id.button9)
        farm3Button.setOnClickListener {
            if(mainVM.farm(200, 1500, mainVM.farm2)) {
                Log.v("Log", "BUY FARM")

            }
        }

        val backButton = findViewById<Button>(R.id.button10)
        val intent = Intent(this, MainActivity::class.java)
        backButton.setOnClickListener {
            mainVM.save()
            startActivity(intent)
        }

        val achButton = findViewById<Button>(R.id.button11)
        val intent2 = Intent(this, AchActivity::class.java)
        achButton.setOnClickListener {
            mainVM.save()
            startActivity(intent2)
        }

    }

}