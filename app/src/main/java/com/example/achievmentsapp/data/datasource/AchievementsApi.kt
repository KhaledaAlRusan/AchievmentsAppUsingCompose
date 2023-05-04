package com.example.achievmentsapp.data.datasource

import com.example.achievmentsapp.domain.models.Response
import retrofit2.http.GET

interface AchievementsApi {


    @GET("/Achievements")
    suspend fun getAchievements(): Response
}