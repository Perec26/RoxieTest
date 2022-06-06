package com.test.roxie.domain.repository

import com.test.roxie.domain.model.Order

interface OrderRepository {

    suspend fun getOrderList(): List<Order>

    fun getOrder(orderId: Int): Order?

}