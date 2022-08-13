package com.sulgorae.domain.datasource

import com.sulgorae.domain.entity.Ticker

interface QuotationDataSource {

    suspend fun getTicker(market: String): Ticker
}
