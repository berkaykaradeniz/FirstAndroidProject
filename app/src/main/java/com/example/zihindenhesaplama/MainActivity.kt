package com.example.zihindenhesaplama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zihindenhesaplama.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toplamabtn.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "1")//Toplama İşlemi
            startActivity(intent)
            finish()
        }
        cikartma.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "2")//Çıkartma İşlemi
            startActivity(intent)
            finish()
        }
        carpma.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "3")//Çarpma İşlemi
            startActivity(intent)
            finish()
        }
        bolme.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "4")//"Bölme İşlemi
            startActivity(intent)
            finish()
        }

        kapat.setOnClickListener {
            finish()
        }

    }
}