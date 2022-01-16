package com.example.zihindenhesaplama

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.os.CountDownTimer;
import kotlinx.android.synthetic.main.activity_toplama.*


class Toplama : AppCompatActivity() {
    private var countDownTimer: CountDownTimer? = null
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toplama)

        var seviye = 1
        var yanlis_cevap = 0
        var dogru_cevap = 0

        seviye_text.text = "Seviye :" + seviye.toString()

        geridon.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        yeni_soru.setOnClickListener{
            //Seviye sistemiyle kullanıcıya daha zor sorular sorulabilmesi sağlanacak.
            //Sayı aralığı artacak.

            secenek1.setBackgroundColor(resources.getColor(R.color.Blue))
            secenek2.setBackgroundColor(resources.getColor(R.color.Blue))
            var a = (1..10* seviye).random()
            var b = (1..10* seviye).random()
            var sonuc = "?"

            dogru_cevap = a + b
            yanlis_cevap = (1..10 * seviye).random()

            var dogru_cevap_konum = (0..1).random()
            islem.text = a.toString() + " + " + b.toString() + " = " + sonuc

            if (dogru_cevap == yanlis_cevap)
                yanlis_cevap = (1..20 * seviye).random()

            if (dogru_cevap_konum == 1) {
                secenek1.text = dogru_cevap.toString()
                secenek2.text = yanlis_cevap.toString()
            }else {
                secenek2.text = dogru_cevap.toString()
                secenek1.text = yanlis_cevap.toString()
            }
        }
        seviye_artir.setOnClickListener{
            seviye += 1
            seviye_text.text = "Seviye :" + seviye.toString()
        }
        seviye_düsür.setOnClickListener{
            if (seviye > 1)
                seviye -= 1
            seviye_text.text = "Seviye :" + seviye.toString()
        }
        seviye_artir_x10.setOnClickListener{
            seviye += 10
            seviye_text.text = "Seviye :" + seviye.toString()
        }
        seviye_düsür_x10.setOnClickListener{
            if (seviye > 10)
                seviye -= 10
            seviye_text.text = "Seviye :" + seviye.toString()
        }
        //Hata var bakılcak ters çalışıyor
        secenek1.setOnClickListener{
            if (dogru_cevap.toString() == secenek1.text.toString())
                secenek1.setBackgroundColor(resources.getColor(R.color.True_Gren))
            else {
                secenek2.setBackgroundColor(resources.getColor(R.color.True_Gren))
                secenek1.setBackgroundColor(RED)
            }
        }
        secenek2.setOnClickListener{
            if (dogru_cevap.toString() == secenek2.text.toString())
                secenek2.setBackgroundColor(resources.getColor(R.color.True_Gren))
            else {
                secenek1.setBackgroundColor(resources.getColor(R.color.True_Gren))
                secenek2.setBackgroundColor(RED)
            }
        }
    }
}