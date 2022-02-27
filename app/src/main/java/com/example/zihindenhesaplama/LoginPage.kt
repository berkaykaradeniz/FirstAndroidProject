package com.example.zihindenhesaplama

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.zihindenhesaplama.databinding.ActivityLoginPageBinding
import com.example.zihindenhesaplama.util.Constants
import com.orhanobut.hawk.Hawk

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = Intent(this, MainMenu::class.java)
/*
        Hawk.init(applicationContext).build();
        Hawk.get<String>("username")?.let {
            if (it.length > 0)
                startActivity(intent)
        }
*/
        binding.btnLogin.setOnClickListener {
            //Hawk.delete("username")
            if ((binding.etUsername.text.length > 3) and (binding.etUsername.text.length < 18)) {
                //Hawk.put("username", binding.etUsername.text)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Kullanıcı adı 3 - 18 karakter arasında olmalı.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}