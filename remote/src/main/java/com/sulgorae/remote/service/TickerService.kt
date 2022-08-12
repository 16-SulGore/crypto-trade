package com.sulgorae.remote.service

import com.sulgorae.domain.entity.Ticker
import retrofit2.http.GET
import retrofit2.http.Query

interface TickerService {

    @GET("/ticker")
    suspend fun getTicker(@Query("market")market: String = "KRW-BTC"): Ticker
}
