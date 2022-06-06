package com.test.roxie.presentation.list.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.test.roxie.presentation.list.model.OrderItemUi

class OrderListAdapter(
    onItemClick: (OrderItemUi) -> Unit
) : AsyncListDifferDelegationAdapter<OrderItemUi>(DIFF_CALLBACK) {

    init {
        delegatesManager.addDelegate(orderListDelegate(onItemClick))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<OrderItemUi>() {
            override fun areItemsTheSame(oldItem: OrderItemUi, newItem: OrderItemUi): Boolean {
                return oldItem.id == oldItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: OrderItemUi, newItem: OrderItemUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}