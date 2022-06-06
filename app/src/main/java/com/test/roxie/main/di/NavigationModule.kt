package com.test.roxie.main.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.test.roxie.main.navigation.MainNavigator
import com.test.roxie.main.navigation.MainNavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single<MainNavigator> { MainNavigatorImpl(get()) }
}
