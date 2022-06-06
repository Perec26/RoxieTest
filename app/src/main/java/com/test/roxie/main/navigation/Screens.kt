package com.test.roxie.main.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test.roxie.presentation.details.DetailsFragment
import com.test.roxie.presentation.list.OrderListFragment

object Screens {
    fun orderListScreen() = FragmentScreen { OrderListFragment() }
    fun detailsScreen(orderId:Int) = FragmentScreen { DetailsFragment.getNewInstance(orderId) }
}