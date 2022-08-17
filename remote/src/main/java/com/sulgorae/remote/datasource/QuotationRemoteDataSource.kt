package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.domain.entity.DayCandleEntity
import com.sulgorae.domain.entity.TickerEntity
import com.sulgorae.remote.service.QuotationService

class QuotationRemoteDataSource(private val quotationService: QuotationService) : QuotationDataSource {

    override suspend fun getTicker(market: String) = runCatching {
        quotationService.getTicker(market).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(defaultTicker)

    override suspend fun getDayCandle(market: String) = runCatching {
        quotationService.getDayCandle(market).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(defaultCandle)

    override suspend fun getDayCandleWithPeriod(market: String, to: String) = runCatching {
        quotationService.getDayCandleByPeriod(market, to).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(defaultCandle)

    companion object {

        val defaultTicker = TickerEntity(market = "", openingPrice = 0.0, highPrice = 0.0, tradePrice = 0.0, prevClosingPrice = 0.0 )

        val defaultCandle = DayCandleEntity(market = "", highPrice = 0.0, lowPrice = 0.0, tradePrice = 0.0, prevClosingPrice = 0.0 )
    }
}
