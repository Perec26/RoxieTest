package com.test.roxie.main.navigation

import com.github.terrakok.cicerone.Router

class MainNavigatorImpl(private val router: Router) : MainNavigator {

    override fun toOrderList() = router.newRootScreen(Screens.orderListScreen())

    override fun toDetails(orderId: Int) = router.navigateTo(Screens.detailsScreen(orderId))

    override fun exit() = router.exit()

}