package com.example.zihindenhesaplama

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_process_page.*

class MainProcessPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_process_page)

        //Bakılacak deger diger sayfaya atılarak kod yazılacak.
        val intent = intent

        var ProcessType = intent.getStringExtra("ProcessType")
        Log.i("test", "Test" +ProcessType.toString())

        when (ProcessType)
        {
            "1"->
            {
                tvProcessTitle.text = "Toplama"
                Log.i("test","Toplama")
            }
            "2"->
            {
                tvProcessTitle.text = "Çıkartma"
                Log.i("test","Çıkartma")
            }
        }

        btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


