package com.example.zihindenhesaplama

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        Hawk.init(applicationContext).build();

        Hawk.get<String>("username")?.let {
            tvUsernameText.setText(it)
        }

        btnLogin.setOnClickListener {
            Hawk.put("username", tvUsernameText)
        }
    }
}