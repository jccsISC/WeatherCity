package com.jccsisc.weathermodule.common.core

import retrofit2.Call
import retrofit2.http.*

interface GenericService {
    @GET
    fun serviceResponseGetNoBody(
        @Url url: String,
        @Query("id") id: String,
        @Query("appid") appid: String
    ): Call<Any>
}