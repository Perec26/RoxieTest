package com.test.roxie.presentation.main

import androidx.lifecycle.ViewModel
import com.test.roxie.main.navigation.MainNavigator

class MainViewModel(
    private val navigator: MainNavigator
) : ViewModel() {

    init {
        navigator.toOrderList()
    }

}