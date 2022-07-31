package com.example.zihindenhesaplama.util



fun randomNewNumber(level: Int, minRange: Int, maxRange: Int): Int {
    var result = (minRange * level..maxRange * level).random()
    return result
}

