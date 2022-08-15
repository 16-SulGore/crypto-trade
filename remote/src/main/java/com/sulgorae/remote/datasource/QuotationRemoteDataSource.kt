package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.remote.service.QuotationService

class QuotationRemoteDataSource(private val tickerService: QuotationService) : QuotationDataSource {

    override suspend fun getTicker(market: String) = runCatching {
        tickerService.getTicker(market).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrThrow()

    override suspend fun getDayCandle(market: String) = runCatching {
        tickerService.getDayCandle(market).toEntities()[0]
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrThrow()
}
