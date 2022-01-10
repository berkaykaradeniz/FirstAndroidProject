package com.example.zihindenhesaplama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toplamabtn = findViewById<Button>(R.id.toplamabtn)
        val kapat = findViewById<Button>(R.id.kapat)

        toplamabtn.setOnClickListener{
            val intent = Intent(this, Toplama::class.java)
            startActivity(intent)
        }

        kapat.setOnClickListener{
            finish()
        }

        }

}