package com.example.achievmentsapp.domain.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "id")
    val id: Int,
    @Json(name = "label")
    val label: String,
    @Json(name = "records")
    val records: List<Record>,
    @Json(name = "title")
    val title: String
)