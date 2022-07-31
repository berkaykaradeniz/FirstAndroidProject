package com.example.zihindenhesaplama

import android.content.Intent
import android.graphics.Color.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zihindenhesaplama.databinding.ActivityLoginPageBinding
import com.example.zihindenhesaplama.databinding.ActivityMainBinding
import com.example.zihindenhesaplama.databinding.ActivityMainProcessPageBinding
import com.example.zihindenhesaplama.util.*


class MainProcessPage : AppCompatActivity() {
    private lateinit var binding: ActivityMainProcessPageBinding

    var levelMain = 1
    var wrongAnswer = 0
    var processType = ""
    var numberOne: Int = 0
    var numberTwo: Int = 0
    var processResult: Int = 0
    var trueCount: Int = 0
    var wrongCount: Int = 0
    var trueAnswer: Int = 0

    //Doğru cevaptan level - level + aralığıunda yanlış cevaplar set edilecek.
    override

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainProcessPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvTrueCount.text = "Doğru : " + trueCount
        binding.tvWrongCount.text = "Yanlış : " + wrongCount

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvLevelText.text = "Seviye :" + levelMain.toString()
        val procesTypeMain = intent.getStringExtra(Constants.PROCESS_TYPE)
        when (procesTypeMain) {
            "1" -> {
                binding.tvProcessTitle.text = "Toplama"
                processType = "+"
            }
            "2" -> {
                binding.tvProcessTitle.text = "Çıkartma"
                processType = "-"
            }
            "3" -> {
                binding.tvProcessTitle.text = "Çarpma"
                processType = "*"
            }
            "4" -> {
                binding.tvProcessTitle.text = "Bölme"
                processType = "/"
            }
        }

        fun newQuestion() {
            numberOne = randomNewNumber(levelMain, 1, 10)
            numberTwo = randomNewNumber(levelMain, 1, 10)
            binding.tvQuestionn.text = numberOne.toString() + " " + processType + " " + numberTwo.toString()
            binding.btnAnswer1.setTextColor(BLACK)
            binding.btnAnswer2.setTextColor(BLACK)
            binding.btnAnswer3.setTextColor(BLACK)
            binding.tvAnswer.setText("?")
        }

        fun levelControl() {
            binding.tvLevelText.text = "Seviye : " + levelMain.toString()
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

        binding.btnLevelUp.setOnClickListener() {
            levelUp(1)
        }
        binding.btnLevelDown.setOnClickListener() {
            levelDown(1)
        }
        binding.btnLevelUp10x.setOnClickListener() {
            levelUp(10)
        }
        binding.btnLevelDown10x.setOnClickListener() {
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
                binding.btnAnswer1.text = trueAnswer.toString()
                binding.btnAnswer2.text = wrongAnswer1.toString()
                binding.btnAnswer3.text = wrongAnswer2.toString()
            } else if (trueAnswerState == 2) {
                binding.btnAnswer2.text = trueAnswer.toString()
                binding.btnAnswer1.text = wrongAnswer1.toString()
                binding.btnAnswer3.text = wrongAnswer2.toString()
            } else {
                binding.btnAnswer3.text = trueAnswer.toString()
                binding.btnAnswer2.text = wrongAnswer1.toString()
                binding.btnAnswer1.text = wrongAnswer2.toString()
            }
        }

        binding.btnAnswer1.setOnClickListener {
            if (binding.btnAnswer1.text != "Doğru") {
                if (binding.btnAnswer1.text.toString() == trueAnswer.toString()) {
                    if (binding.tvAnswer.text == "?")
                        trueCount += 1
                    binding.btnAnswer1.setText("Doğru")
                    binding.btnAnswer1.setTextColor(BLUE)
                    binding.tvAnswer.setText(trueAnswer.toString())
                } else {
                    if (binding.tvAnswer.text == "?")
                        wrongCount += 1
                    binding.btnAnswer1.setTextColor(RED)
                }

                binding.tvTrueCount.text = "Doğru : " + trueCount
                binding.tvWrongCount.text = "Yanlış : " + wrongCount
                if (binding.cbFastQuestions.isChecked) {
                    newQuestion()
                    Answers()
                }
            }
        }
        binding.btnAnswer2.setOnClickListener {
            if (binding.btnAnswer2.text != "Doğru") {
                if (binding.btnAnswer2.text.toString() == trueAnswer.toString()) {
                    if (binding.tvAnswer.text == "?")
                        trueCount += 1
                    binding.btnAnswer2.setText("Doğru")
                    binding.btnAnswer2.setTextColor(BLUE)
                    binding.tvAnswer.setText(trueAnswer.toString())
                } else {
                    if (binding.tvAnswer.text == "?")
                        wrongCount += 1
                    binding.btnAnswer2.setTextColor(RED)
                }

                binding.tvTrueCount.text = "Doğru : " + trueCount
                binding.tvWrongCount.text = "Yanlış : " + wrongCount
                if (binding.cbFastQuestions.isChecked) {
                    newQuestion()
                    Answers()
                }
            }
        }
        binding.btnAnswer3.setOnClickListener {
            if (binding.btnAnswer3.text != "Doğru") {
                if (binding.btnAnswer3.text.toString() == trueAnswer.toString()) {
                    if (binding.tvAnswer.text == "?")
                        trueCount += 1
                    binding.btnAnswer3.setText("Doğru")
                    binding.btnAnswer3.setTextColor(BLUE)
                    binding.tvAnswer.setText(trueAnswer.toString())
                } else {
                    if (binding.tvAnswer.text == "?")
                        wrongCount += 1
                    binding.btnAnswer3.setTextColor(RED)
                }

                binding.tvTrueCount.text = "Doğru : " + trueCount
                binding.tvWrongCount.text = "Yanlış : " + wrongCount
                if (binding.cbFastQuestions.isChecked) {
                    newQuestion()
                    Answers()
                }
            }
        }

        //Form Create Olduğunda
        newQuestion()
        Answers()

        binding.btnNewQuestion.setOnClickListener()
        {
            newQuestion()
            Answers()
        }

    }
}


