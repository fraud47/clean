package com.hamsoft.cleaning_services.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.hamsoft.cleaning_services.data.auth.remote.AuthRepositoryImpl
import com.hamsoft.cleaning_services.data.auth.remote.BaseApi
import com.hamsoft.cleaning_services.domain.repo.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideBaseApi(): BaseApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.2:2000/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
    @Provides
    @Singleton
    fun provideSharedPref(app: Application): SharedPreferences {
        return app.getSharedPreferences("prefs", MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideAuthRepository(api: BaseApi, prefs: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(api, prefs)
    }
}