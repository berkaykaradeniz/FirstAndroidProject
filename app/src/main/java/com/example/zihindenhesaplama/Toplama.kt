package com.example.zihindenhesaplama

import android.content.Intent
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.os.CountDownTimer;
import com.example.zihindenhesaplama.databinding.ActivityMainProcessPageBinding
import com.example.zihindenhesaplama.databinding.ActivityToplamaBinding


class Toplama : AppCompatActivity() {
    private var countDownTimer: CountDownTimer? = null
    var textView: TextView? = null
    private lateinit var binding: ActivityToplamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToplamaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var seviye = 1
        var yanlis_cevap = 0
        var dogru_cevap = 0

        binding.seviyeText.text = "Seviye :" + seviye.toString()

        binding.geridon.setOnClickListener{
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
        binding.yeniSoru.setOnClickListener{
            //Seviye sistemiyle kullanıcıya daha zor sorular sorulabilmesi sağlanacak.
            //Sayı aralığı artacak.

            binding.secenek1.setBackgroundColor(resources.getColor(R.color.Blue))
            binding.secenek2.setBackgroundColor(resources.getColor(R.color.Blue))
            var a = (1..10* seviye).random()
            var b = (1..10* seviye).random()
            var sonuc = "?"

            dogru_cevap = a + b
            yanlis_cevap = (1..10 * seviye).random()

            var dogru_cevap_konum = (0..1).random()
            binding.islem.text = a.toString() + " + " + b.toString() + " = " + sonuc

            if (dogru_cevap == yanlis_cevap)
                yanlis_cevap = (1..20 * seviye).random()

            if (dogru_cevap_konum == 1) {
                binding.secenek1.text = dogru_cevap.toString()
                binding.secenek2.text = yanlis_cevap.toString()
            }else {
                binding.secenek2.text = dogru_cevap.toString()
                binding.secenek1.text = yanlis_cevap.toString()
            }
        }
        binding.seviyeArtir.setOnClickListener{
            seviye += 1
            binding.seviyeText.text = "Seviye :" + seviye.toString()
        }
        binding.seviyeDSR.setOnClickListener{
            if (seviye > 1)
                seviye -= 1
            binding.seviyeText.text = "Seviye :" + seviye.toString()
        }
        binding.seviyeArtirX10.setOnClickListener{
            seviye += 10
            binding.seviyeText.text = "Seviye :" + seviye.toString()
        }
        binding.seviyeDSRX10.setOnClickListener{
            if (seviye > 10)
                seviye -= 10
            binding.seviyeText.text = "Seviye :" + seviye.toString()
        }
        //Hata var bakılcak ters çalışıyor
        binding.secenek1.setOnClickListener{
            if (dogru_cevap.toString() == binding.secenek1.text.toString())
                binding.secenek1.setBackgroundColor(resources.getColor(R.color.True_Gren))
            else {
                binding.secenek2.setBackgroundColor(resources.getColor(R.color.True_Gren))
                binding.secenek1.setBackgroundColor(RED)
            }
        }
        binding.secenek2.setOnClickListener{
            if (dogru_cevap.toString() == binding.secenek2.text.toString())
                binding.secenek2.setBackgroundColor(resources.getColor(R.color.True_Gren))
            else {
                binding.secenek1.setBackgroundColor(resources.getColor(R.color.True_Gren))
                binding.secenek2.setBackgroundColor(RED)
            }
        }
    }
}