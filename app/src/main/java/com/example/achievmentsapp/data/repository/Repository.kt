package com.example.achievmentsapp.data.repository

import com.example.achievmentsapp.data.datasource.AchievementsApi
import com.example.achievmentsapp.domain.models.Data

class Repository(private val achievementsApi: AchievementsApi){
    suspend fun getAchievements():List<Data>{
        return achievementsApi.getAchievements().data
    }
}