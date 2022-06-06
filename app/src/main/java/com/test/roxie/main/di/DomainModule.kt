package com.test.roxie.main.di

import com.test.roxie.domain.OrderInteractor
import com.test.roxie.domain.OrderInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    factory<OrderInteractor> { OrderInteractorImpl(get(), get()) }
}