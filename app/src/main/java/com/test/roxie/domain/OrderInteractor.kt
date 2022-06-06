package com.test.roxie.domain

import com.test.roxie.domain.model.Order

interface OrderInteractor {

    suspend fun getOrderList(): List<Order>
    suspend fun getOrder(orderId: Int): Order?

}