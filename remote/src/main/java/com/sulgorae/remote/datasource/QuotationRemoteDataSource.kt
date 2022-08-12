package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.remote.service.TickerService

class QuotationRemoteDataSource(private val tickerService: TickerService) : QuotationDataSource {

    override suspend fun getTicker(market: String) = runCatching {
        tickerService.getTicker(market)
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrThrow()
}
