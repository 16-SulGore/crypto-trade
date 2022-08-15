package com.sulgorae.remote.service

import com.sulgorae.domain.entity.TickerEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface TickerService {

    @GET("/ticker")
    suspend fun getTicker(@Query("market")market: String = "KRW-BTC"): TickerEntity
}
