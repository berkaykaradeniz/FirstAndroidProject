package com.example.zihindenhesaplama.remote

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("user_id") val androidID: String?,
    @SerializedName("user_name") val userName: Editable?,
)
