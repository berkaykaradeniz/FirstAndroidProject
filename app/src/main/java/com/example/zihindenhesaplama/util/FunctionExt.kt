package com.example.zihindenhesaplama.util

import kotlinx.android.synthetic.main.activity_main_process_page.*


fun randomNewNumber(level: Int, minRange: Int, maxRange: Int): Int {
    var result = (minRange * level..maxRange * level).random()
    return result
}

