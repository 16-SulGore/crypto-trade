package com.sulgorae.remote.service

import com.sulgorae.data.entity.candles.days.Days
import com.sulgorae.data.entity.ticker.Ticker
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotationService {

    @GET("/ticker")
    suspend fun getTicker(@Query("market") market: String = "KRW-BTC"): Ticker

    @GET("candles/days")
    suspend fun getDayCandle(@Query("market") market: String = "KRW-BTC"): Days
}
