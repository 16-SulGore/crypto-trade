package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.domain.entity.DayCandleEntity
import com.sulgorae.domain.entity.TickerEntity
import com.sulgorae.remote.service.QuotationService

class QuotationRemoteDataSource(private val tickerService: QuotationService) : QuotationDataSource {

    override suspend fun getTicker(market: String) = runCatching {
        tickerService.getTicker(market).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(defaultTicker)

    override suspend fun getDayCandle(market: String) = runCatching {
        tickerService.getDayCandle(market).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(defaultCandle)

    companion object {
        val defaultTicker = TickerEntity(market = "", openingPrice = 0.0, highPrice = 0.0, tradePrice = 0.0, prevClosingPrice = 0.0 )

        val defaultCandle = DayCandleEntity(market = "", highPrice = 0.0, lowPrice = 0.0, tradePrice = 0.0, prevClosingPrice = 0.0 )
    }
}
