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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clicker1.R
import com.example.clicker1.data.MainViewDataModel


class MainActivity : AppCompatActivity() {

    private val mainVM: MainViewDataModel by viewModels()

    @SuppressLint("MissingInflatedId", "UnsafeIntentLaunch", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        var multiple = mainVM.multiple
        val textCount = findViewById<TextView>(R.id.clicks)
        val clickButton = findViewById<Button>(R.id.clickbutton)
        clickButton.setOnClickListener {
            mainVM.plus()
        }

        mainVM.count.observe(this) { count ->
            textCount.text = count.toString()
        }

        val shopButton = findViewById<Button>(R.id.shopButton)
        val intent = Intent(this, ShopActivity::class.java)
        shopButton.setOnClickListener {
            startActivity(intent)
        }

        val resetButton = findViewById<Button>(R.id.reset)
        resetButton.setOnClickListener {
            mainVM.reset()
        }

        val achivementsButton = findViewById<Button>(R.id.button3)
        val intent2 = Intent(this, AchActivity::class.java)
        achivementsButton.setOnClickListener {
            startActivity(intent2)
        }
    }
}
