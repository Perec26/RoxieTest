package com.test.roxie.main.navigation

interface MainNavigator {

    fun toOrderList()

    fun toDetails(orderId: Int)

    fun exit()

}