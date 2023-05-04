package com.example.achievmentsapp.data.di

import com.example.achievmentsapp.data.datasource.AchievementsApi
import com.example.achievmentsapp.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(achievementsApi: AchievementsApi):Repository{
        return Repository(achievementsApi)
    }
}