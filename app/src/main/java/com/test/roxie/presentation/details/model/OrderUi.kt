package com.test.roxie.presentation.details.model

import com.test.roxie.base.util.DateTimeFormats
import com.test.roxie.domain.model.Order

private const val AMOUNT_DIVIDER = 100

data class OrderUi(
    val id: Int,
    val startAddress: String,
    val endAddress: String,
    val date: String,
    val time: String,
    val amount: String,
    val regNumber: String,
    val modelName: String,
    val photo: String,
    val driverName: String
)

fun Order.toUi(): OrderUi {
    return OrderUi(
        id = id,
        startAddress = "${startAddress.city}, ${startAddress.address}",
        endAddress = "${endAddress.city}, ${endAddress.address}",
        date = orderTime.toLocalDate().format(DateTimeFormats.FORMATTER_DATE),
        time = orderTime.toLocalTime().format(DateTimeFormats.FORMATTER_TIME),
        amount = "${price.amount / AMOUNT_DIVIDER}.${price.amount % AMOUNT_DIVIDER} ${price.currency}",
        regNumber = vehicle.regNumber,
        modelName = vehicle.modelName,
        photo = vehicle.photo,
        driverName = vehicle.driverName
    )
}