package com.example.achievmentsapp.domain.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Record(
    @Json(name = "active")
    val active: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "label")
    val label: String,
    @Json(name = "title")
    val title: String
)