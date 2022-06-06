package com.test.roxie.data.model

import com.test.roxie.domain.model.Address
import com.test.roxie.domain.model.Order
import com.test.roxie.domain.model.Price
import com.test.roxie.domain.model.Vehicle
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class OrderResponse(
    val id: Int,
    val startAddress: AddressResponse,
    val endAddress: AddressResponse,
    val price: PriceResponse,
    val orderTime: String,
    val vehicle: VehicleResponse
)

data class AddressResponse(
    val city: String,
    val address: String
)

data class PriceResponse(
    val amount: Int,
    val currency: String
)

data class VehicleResponse(
    val regNumber: String,
    val modelName: String,
    val photo: String,
    val driverName: String
)

fun List<OrderResponse>.toDomain() = map { it.toDomain() }

fun OrderResponse.toDomain(): Order {
    return Order(
        id = id,
        startAddress = startAddress.toDomain(),
        endAddress = endAddress.toDomain(),
        price = price.toDomain(),
        orderTime = LocalDateTime.parse(orderTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME),
        vehicle = vehicle.toDomain()
    )
}

private fun AddressResponse.toDomain(): Address {
    return Address(city, address)
}

private fun PriceResponse.toDomain(): Price {
    return Price(amount, currency)
}

private fun VehicleResponse.toDomain(): Vehicle {
    return Vehicle(
        regNumber = regNumber,
        modelName = modelName,
        photo = photo,
        driverName = driverName
    )
}
