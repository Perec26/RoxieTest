package com.test.roxie.domain.model

import java.time.LocalDateTime

data class Order(
    val id: Int,
    val startAddress: Address,
    val endAddress: Address,
    val price: Price,
    val orderTime: LocalDateTime,
    val vehicle: Vehicle
)

data class Address(
    val city: String,
    val address: String
)

data class Price(
    val amount: Int,
    val currency: String
)

data class Vehicle(
    val regNumber: String,
    val modelName: String,
    val photo: String,
    val driverName: String
)
