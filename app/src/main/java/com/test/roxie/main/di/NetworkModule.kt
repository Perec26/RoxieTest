package com.test.roxie.main.di

import com.google.gson.GsonBuilder
import com.test.roxie.BuildConfig
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { GsonBuilder().create() }
    single<Converter.Factory> { GsonConverterFactory.create(get()) }
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(get())
            .build()
    }
}