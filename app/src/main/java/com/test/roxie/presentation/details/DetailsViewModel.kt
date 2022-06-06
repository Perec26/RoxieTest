package com.test.roxie.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.roxie.domain.OrderInteractor
import com.test.roxie.main.navigation.MainNavigator
import com.test.roxie.presentation.details.model.toUi
import com.test.roxie.presentation.main.ViewState
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val orderId: Int,
    private val navigator: MainNavigator,
    private val interactor: OrderInteractor
) : ViewModel() {

    val currentOrder = MutableLiveData<DetailsState>(ViewState.Loading())

    init {
        viewModelScope.launch {
            getOrder()
        }
    }

    private suspend fun getOrder() {
        val order = interactor.getOrder(orderId)
        currentOrder.value = if (order != null) ViewState.Success(order.toUi()) else ViewState.Error()
    }

    fun onBackPressed() {
        navigator.exit()
    }

}