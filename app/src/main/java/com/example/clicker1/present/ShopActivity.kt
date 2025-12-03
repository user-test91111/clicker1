package com.example.clicker1.present

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.clicker1.R
import com.example.clicker1.data.MainViewDataModel
import com.example.clicker1.domain.MainViewModelDomain

class ShopActivity : AppCompatActivity() {

    private var factory = MainViewModelDomain()
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

        val mainVM = ViewModelProvider(this, factory).get(MainViewDataModel::class.java)
        var count = mainVM.count
        var multiple = mainVM.multiple
        val costx2 = 10
        val costx10 = 50
        val costx100 = 100
        val costFarm1 = 75
        val costFarm2 = 150
        val costFarm3 = 650

        val textCount = findViewById<TextView>(R.id.count)
        Log.v("F", mainVM.count.toString())
        textCount.setText(mainVM.count.toString())

        val x2Button = findViewById<Button>(R.id.button6)
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

        val x100Button = findViewById<Button>(R.id.button)
        x100Button.setOnClickListener {
            if (count >= costx100){
                count -= costx100
                multiple = 100
            }
        }

        val farm1Button = findViewById<Button>(R.id.button7)
        farm1Button.setOnClickListener {
            if (count >= costFarm1){
                count -= costFarm1
                multiple = 2
            }
        }

        val farm2Button = findViewById<Button>(R.id.button8)
        farm2Button.setOnClickListener {
            if (count >= costFarm2){
                count -= costFarm2
                multiple = 10
            }
        }

        val farm3Button = findViewById<Button>(R.id.button9)
        farm3Button.setOnClickListener {
            if (count >= costFarm3){
                count -= costFarm3
                multiple = 100
            }
        }

        val backButton = findViewById<Button>(R.id.button10)
        val intent = Intent(this, MainActivity::class.java)
        backButton.setOnClickListener{
//            startActivity(intent)
            finish()
        }

        val achButton = findViewById<Button>(R.id.button11)
        val intent2 = Intent(this, AchActivity::class.java)
        achButton.setOnClickListener{
            startActivity(intent2)
        }
    }
}