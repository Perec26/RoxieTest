package com.test.roxie.data.datasource

import com.test.roxie.domain.model.Order

class LocalMemoryImpl : LocalMemory {

    private var orderList = listOf<Order>()

    override fun saveOrderList(ordersList: List<Order>) {
        orderList = ordersList
    }

    override fun getOrder(orderId: Int): Order? {
       return orderList.find { it.id == orderId }
    }
}