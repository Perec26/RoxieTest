package com.test.roxie.data.datasource

import com.test.roxie.data.model.OrderResponse
import retrofit2.http.GET

interface OrderApi {

    @GET("orders.json")
    suspend fun getOrderList(): List<OrderResponse>

}