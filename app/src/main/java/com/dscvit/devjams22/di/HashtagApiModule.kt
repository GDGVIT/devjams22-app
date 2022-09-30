package com.dscvit.devjams22.di

import com.dscvit.devjams22.common.Constants
import com.dscvit.devjams22.data.repository.hashtagapi.HashtagApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HashtagApiModule {
    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): HashtagApi {
        return builder
            .build()
            .create(HashtagApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())

    }


}