package com.test.roxie.main.di

import com.test.roxie.presentation.list.OrderListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val orderListModule = module {
    viewModel { OrderListViewModel(get(), get()) }
}