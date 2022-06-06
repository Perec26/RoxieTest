package com.test.roxie.data.datasource

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageApi {

    @GET("images/{imageName}")
    suspend fun getImage(@Path("imageName") imageName:String): ResponseBody

}