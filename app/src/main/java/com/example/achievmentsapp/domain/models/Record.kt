package com.example.achievmentsapp.domain.models

import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("title")
    val title: String
)