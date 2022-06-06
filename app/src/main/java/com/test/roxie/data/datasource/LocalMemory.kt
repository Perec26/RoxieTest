package com.test.roxie.data.datasource

import com.test.roxie.domain.model.Order

interface LocalMemory {
    fun saveOrderList(ordersList :List<Order>)
    fun getOrder(orderId:Int): Order?
}