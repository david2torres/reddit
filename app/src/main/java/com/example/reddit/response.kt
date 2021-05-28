package com.example.reddit

import com.google.gson.annotations.SerializedName

class response (
    @SerializedName("data") var data: List<String>
)