package com.example.zihindenhesaplama

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zihindenhesaplama.util.*
import kotlinx.android.synthetic.main.activity_main_process_page.*
import kotlinx.android.synthetic.main.activity_toplama.*
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.round

class MainProcessPage : AppCompatActivity() {
    var levelMain = 1
    var wrongAnswer = 0
    var correctAnswer = 0
    var processType = ""
    var numberOne: Int = 0
    var numberTwo: Int = 0
    var processResult: Int = 0

    //Doğru cevaptan level - level + aralığıunda yanlış cevaplar set edilecek.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_process_page)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        tvLevelText.text = "Seviye :" + levelMain.toString()
        val procesTypeMain = intent.getStringExtra(Constants.PROCESS_TYPE)
        when (procesTypeMain) {
            "1" -> {
                tvProcessTitle.text = "Toplama"
                processType = "+"
            }
            "2" -> {
                tvProcessTitle.text = "Çıkartma"
                processType = "-"
            }
            "3" -> {
                tvProcessTitle.text = "Çarpma"
                processType = "*"
            }
            "4" -> {
                tvProcessTitle.text = "Bölme"
                processType = "/"
            }
        }

        fun newQuestion() {
            numberOne = randomNewNumber(levelMain, 1, 10)
            numberTwo = randomNewNumber(levelMain, 1, 10)
            tvQuestionn.text = numberOne.toString() + " " + processType + " " + numberTwo.toString()
        }

        fun levelControl() {
            tvLevelText.text = "Seviye : " + levelMain.toString()
        }

        fun levelUp(upLevel: Int) {
            if (levelMain > 0)
                levelMain += upLevel
            levelControl()
        }

        fun levelDown(downLevel: Int) {
            if (levelMain > 1)
                levelMain -= downLevel
            levelControl()
        }

        btnLevelUp.setOnClickListener() {
            levelUp(1)
        }
        btnLevelDown.setOnClickListener() {
            levelDown(1)
        }
        btnLevelUp10x.setOnClickListener() {
            levelUp(10)
        }
        btnLevelDown10x.setOnClickListener() {
            if (levelMain > 10)
                levelDown(10)
        }
        //Bölme işlemi yeni fonksiyon yazılacak.
        fun processMain(x: Int, y: Int, process: String): Int {
            when (process) {
                "+" -> processResult = x + y
                "-" -> processResult = x - y
                "*" -> processResult = x * y
                "/" -> processResult = x / y
            }
            return processResult
        }

        var trueAnswer: Int = 0
        var wrongAnswer1: Int = 0
        var wrongAnswer2: Int = 0

        fun whoIsLow(x: Int, y: Int): Int {
            if (x < y)
                return x
            else
                return y
        }

        fun Answers() {//Doğru  ve yanlış cevabı bulup ekrana yazar
            trueAnswer = processMain(numberOne, numberTwo, processType)
            wrongAnswer1 = randomNewNumber(levelMain, 1, 10)
            wrongAnswer2 = randomNewNumber(levelMain, 1, 10)

            var trueAnswerState = (0..2).random()

            //Yanlış cevap min numberdan küçükse tekrar yanlış cevabı döndür
            if (trueAnswer == wrongAnswer1)
                wrongAnswer1 = randomNewNumber(levelMain, 1, 10)

            if (trueAnswer == wrongAnswer2)
                wrongAnswer2 = randomNewNumber(levelMain, 1, 10)

            if (trueAnswerState == 1) {//Random Şık
                btnAnswer1.text = trueAnswer.toString()
                btnAnswer2.text = wrongAnswer1.toString()
                btnAnswer3.text = wrongAnswer2.toString()
            } else if (trueAnswerState == 2) {
                btnAnswer2.text = trueAnswer.toString()
                btnAnswer1.text = wrongAnswer1.toString()
                btnAnswer3.text = wrongAnswer2.toString()
            } else {
                btnAnswer3.text = trueAnswer.toString()
                btnAnswer2.text = wrongAnswer1.toString()
                btnAnswer1.text = wrongAnswer2.toString()
            }
        }
        //Form Create Olduğunda
        newQuestion()
        Answers()

        btnNewQuestion.setOnClickListener()
        {
            newQuestion()
            Answers()
        }

    }
}


