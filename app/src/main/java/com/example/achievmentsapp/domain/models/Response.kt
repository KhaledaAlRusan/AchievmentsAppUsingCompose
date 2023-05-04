package com.example.achievmentsapp.domain.models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val `data`: List<Data>
)