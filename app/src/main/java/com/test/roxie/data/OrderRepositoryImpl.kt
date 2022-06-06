package com.test.roxie.data

import com.test.roxie.data.datasource.LocalMemory
import com.test.roxie.data.datasource.OrderApi
import com.test.roxie.data.model.toDomain
import com.test.roxie.domain.model.Order
import com.test.roxie.domain.repository.OrderRepository

class OrderRepositoryImpl(
    private val api: OrderApi,
    private val localMemory: LocalMemory
) : OrderRepository {

    override suspend fun getOrderList(): List<Order> {
        val orderList = api.getOrderList().toDomain()
        localMemory.saveOrderList(orderList)
        return orderList
    }

    override fun getOrder(orderId: Int): Order? {
        return localMemory.getOrder(orderId)
    }


}