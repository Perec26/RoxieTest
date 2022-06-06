package com.test.roxie.main.di

import com.test.roxie.base.util.ImageHandler
import com.test.roxie.data.ImageRepositoryImpl
import com.test.roxie.data.OrderRepositoryImpl
import com.test.roxie.data.datasource.ImageApi
import com.test.roxie.data.datasource.LocalMemory
import com.test.roxie.data.datasource.LocalMemoryImpl
import com.test.roxie.data.datasource.OrderApi
import com.test.roxie.data.work.WorkHelper
import com.test.roxie.data.work.WorkHelperImpl
import com.test.roxie.domain.repository.ImageRepository
import com.test.roxie.domain.repository.OrderRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    single<LocalMemory> { LocalMemoryImpl() }
    single { get<Retrofit>().create(OrderApi::class.java) }
    single { get<Retrofit>().create(ImageApi::class.java) }
    single<OrderRepository> { OrderRepositoryImpl(get(), get()) }
    single<ImageRepository> { ImageRepositoryImpl(get(), get(), get()) }
    factory<WorkHelper> { WorkHelperImpl(get()) }
    factory { ImageHandler(get()) }
}