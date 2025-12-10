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
            mainVM.buy( 50, 2)
        }

        val x10Button = findViewById<Button>(R.id.button5)
        x10Button.setOnClickListener {
            mainVM.buy(200, 10)
        }

        val x100Button = findViewById<Button>(R.id.button)
        x100Button.setOnClickListener {
            mainVM.buy(1000, 100)
        }

//        val farm1Button = findViewById<Button>(R.id.button7)
//        farm1Button.setOnClickListener {
//            if (mainVM.count >= costFarm1) {
//                mainVM.count -= costFarm1
//                mainVM.multiple = 2
//            }
//        }
//
//        val farm2Button = findViewById<Button>(R.id.button8)
//        farm2Button.setOnClickListener {
//            if (mainVM.count >= costFarm2) {
//                mainVM.count -= costFarm2
//                mainVM.multiple = 10
//            }
//        }
//
//        val farm3Button = findViewById<Button>(R.id.button9)
//        farm3Button.setOnClickListener {
//            if (mainVM.count >= costFarm3) {
//                mainVM.count -= costFarm3
//                mainVM.multiple = 100
//            }
//        }

        val backButton = findViewById<Button>(R.id.button10)
        val intent = Intent(this, MainActivity::class.java)
        backButton.setOnClickListener {
            startActivity(intent)
//            finish()
        }

        val achButton = findViewById<Button>(R.id.button11)
        val intent2 = Intent(this, AchActivity::class.java)
        achButton.setOnClickListener {
            startActivity(intent2)
        }
    }
}