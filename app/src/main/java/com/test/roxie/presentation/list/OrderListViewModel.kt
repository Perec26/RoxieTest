package com.test.roxie.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.roxie.domain.OrderInteractor
import com.test.roxie.main.navigation.MainNavigator
import com.test.roxie.presentation.list.model.OrderItemUi
import com.test.roxie.presentation.list.model.toItemUi
import com.test.roxie.presentation.main.ViewState
import kotlinx.coroutines.launch

class OrderListViewModel(
    private val navigator: MainNavigator,
    private val interactor: OrderInteractor
) : ViewModel() {

    val state = MutableLiveData<OrderListState>()

    init {
        getOrderList()
    }

    private fun getOrderList() {
        state.value = ViewState.Loading()
        viewModelScope.launch() {
            try {
                val list = interactor.getOrderList()
                state.value = ViewState.Success(list.toItemUi())
            } catch (t: Throwable) {
                state.value = ViewState.Error()
            }
        }
    }

    fun onOrderClick(orderItemUi: OrderItemUi) {
        navigator.toDetails(orderItemUi.id)
    }

    fun onRetryClick() {
        getOrderList()
    }

}