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
import com.example.clicker1.R
import com.example.clicker1.data.MainViewDataModel
import kotlin.getValue

class AchActivity : AppCompatActivity() {

    private val mainVM: MainViewDataModel by viewModels()

@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_ach)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
    val backButton = findViewById<Button>(R.id.button4)
    backButton.setOnClickListener {
        finish()
    }
    val shopButton = findViewById<Button>(R.id.button2)
    val intent = Intent(this, ShopActivity::class.java)
    shopButton.setOnClickListener {
        startActivity(intent)
    }

    val texta1 = findViewById<TextView>(R.id.a1)
    mainVM.count.observe(this) { count ->
        texta1.text = count.toString() + "/1000"
        if (count >= 1000){
        texta1.text = "1000/1000"
        }
    }

    val texta2 = findViewById<TextView>(R.id.a1)
    mainVM.count.observe(this) { count ->
        texta2.text = count.toString() + "/10000"
        if (count >= 10000){
            texta2.text = "10000/10000"
        }
    }

    val texta3 = findViewById<TextView>(R.id.a3)
        texta3.text = mainVM.bought.toString() + "/6"
        if (mainVM.bought.value!! >= 6){
            texta3.text = "6/6"
        }


}
}