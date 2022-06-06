package com.test.roxie.main.di

import com.test.roxie.presentation.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    viewModel { (orderId: Int) -> DetailsViewModel(orderId, get(), get()) }
}