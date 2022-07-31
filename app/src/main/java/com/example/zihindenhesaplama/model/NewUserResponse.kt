package com.example.zihindenhesaplama


import com.google.gson.annotations.SerializedName

data class newUserResponse(
    @SerializedName("message")
    val message: String, // Yeni kayıt eklendi
    @SerializedName("status")
    val status: String // True
)