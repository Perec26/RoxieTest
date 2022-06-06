package com.test.roxie.domain

import com.test.roxie.domain.model.Order
import com.test.roxie.domain.repository.ImageRepository
import com.test.roxie.domain.repository.OrderRepository

class OrderInteractorImpl(
    private val repository: OrderRepository,
    private val imageRepository: ImageRepository
) : OrderInteractor {

    override suspend fun getOrderList(): List<Order> {
        return repository.getOrderList()
    }

    override suspend fun getOrder(orderId: Int): Order? {
        val order = repository.getOrder(orderId)
        order?.let { imageRepository.loadImage(it.vehicle.photo) }
        return order
    }

}