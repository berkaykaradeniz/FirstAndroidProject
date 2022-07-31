package com.example.zihindenhesaplama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.example.zihindenhesaplama.remote.RestApiService
import com.example.zihindenhesaplama.remote.UserInfo
import com.example.zihindenhesaplama.util.Constants
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val id: String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val username: Editable? = etUsername.text

        val apiService = RestApiService()

        val userInfo = UserInfo(
            androidID = id,
            userName = username
        )

        btnLogin.setOnClickListener {
            apiService.addUser(userInfo){
                Log.i("error",it.toString())
            }

            Log.i("error","testtttttttttttttttttttttttttttttttttttttttttttttttttttttt")

            val intent = Intent(this, MainMenu::class.java)
            intent.putExtra(Constants.ANDROID_ID, id)//Toplama İşlemi
            startActivity(intent)
            finish()
        }
    }
}