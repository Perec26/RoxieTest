package com.test.roxie.presentation.main

sealed class ViewState<T> {
    data class Success<T>(val data: T) : ViewState<T>()
    class Error<T> : ViewState<T>()
    class Loading<T> : ViewState<T>()
}