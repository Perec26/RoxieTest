package com.test.roxie.presentation.list.recycler

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.test.roxie.R
import com.test.roxie.databinding.ItemOrderBinding
import com.test.roxie.presentation.list.model.OrderItemUi

fun orderListDelegate(
    onItemClick: (OrderItemUi) -> Unit
) = adapterDelegateViewBinding<OrderItemUi, OrderItemUi, ItemOrderBinding>(
    {
            layoutInflater, root -> ItemOrderBinding.inflate(layoutInflater, root, false)
    }
) {

    bind {
        with(item) {
            binding.amount.text = context.getString(R.string.amount, amount)
            binding.date.text = context.getString(R.string.date, date)
            binding.startAddress.text = context.getString(R.string.start_address, startAddress)
            binding.endAddress.text = context.getString(R.string.end_address, endAddress)
            binding.root.setOnClickListener { onItemClick.invoke(this) }
        }
    }
}