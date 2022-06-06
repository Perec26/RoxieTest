package com.test.roxie.presentation.list.model

import com.test.roxie.base.util.DateTimeFormats
import com.test.roxie.domain.model.Order

private const val AMOUNT_DIVIDER = 100

data class OrderItemUi(
    val id: Int,
    val startAddress: String,
    val endAddress: String,
    val date: String,
    val amount: String
)

fun List<Order>.toItemUi() = map { it.toItemUi() }

fun Order.toItemUi(): OrderItemUi {
    return OrderItemUi(
        id = id,
        startAddress = "${startAddress.city}, ${startAddress.address}",
        endAddress = "${endAddress.city}, ${endAddress.address}",
        date = orderTime.toLocalDate().format(DateTimeFormats.FORMATTER_DATE),
        amount = "${price.amount / AMOUNT_DIVIDER}.${price.amount % AMOUNT_DIVIDER} ${price.currency}",

        )
}