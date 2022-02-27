package com.example.zihindenhesaplama

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zihindenhesaplama.databinding.ActivityLoginPageBinding
import com.example.zihindenhesaplama.databinding.ActivityMainBinding
import com.example.zihindenhesaplama.util.Constants
import com.orhanobut.hawk.Hawk

class MainMenu : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*Hawk.get<String>("username")?.let {
            if (it.length > 0)
                binding.tvUsername.text = it
        }
        */
        binding.toplamabtn.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "1")//Toplama İşlemi
            startActivity(intent)
            finish()
        }
        binding.cikartma.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "2")//Çıkartma İşlemi
            startActivity(intent)
            finish()
        }
        binding.carpma.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "3")//Çarpma İşlemi
            startActivity(intent)
            finish()
        }
        binding.bolme.setOnClickListener {
            val intent = Intent(this, MainProcessPage::class.java)
            intent.putExtra(Constants.PROCESS_TYPE, "4")//"Bölme İşlemi
            startActivity(intent)
            finish()
        }

        binding.kapat.setOnClickListener {
            finish()
        }

    }
}