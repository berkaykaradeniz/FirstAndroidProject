package com.example.zihindenhesaplama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toplamabtn.setOnClickListener{
            val intent = Intent(this, MainProcessPage::class.java)
            startActivity(intent)
        }

        kapat.setOnClickListener{
            finish()
        }

    }
}