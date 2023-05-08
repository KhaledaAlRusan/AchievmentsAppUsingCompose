package com.example.achievmentsapp.data.di

import com.example.achievmentsapp.data.datasource.AchievementsApi
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val baseUrl = "https://786b905e-735c-4be6-adfb-949d5dadee32.mock.pstmn.io/"


    @Provides
    @Singleton
    fun provideRetrofit(factory: Converter.Factory): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .build()
    }

    @Provides
    @Singleton
    fun achievementApi(retrofit: Retrofit):AchievementsApi{
        return retrofit.create(AchievementsApi::class.java)
    }

    @Provides
    @Reusable
    fun provideMoshi():Moshi{
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Wrapped.ADAPTER_FACTORY)
            .build()
    }


    @Provides
    @Reusable
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

}