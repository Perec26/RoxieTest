package com.test.roxie.main

import android.app.Application
import com.test.roxie.main.di.dataModule
import com.test.roxie.main.di.detailsModule
import com.test.roxie.main.di.domainModule
import com.test.roxie.main.di.mainModule
import com.test.roxie.main.di.navigationModule
import com.test.roxie.main.di.networkModule
import com.test.roxie.main.di.orderListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        startKoin {
            androidContext(this@App)
            modules(
                domainModule,
                networkModule,
                dataModule,
                navigationModule,
                orderListModule,
                detailsModule,
                mainModule
            )
        }
    }

}