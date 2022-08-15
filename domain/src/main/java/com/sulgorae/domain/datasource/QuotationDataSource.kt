package com.sulgorae.domain.datasource

import com.sulgorae.domain.entity.TickerEntity

interface QuotationDataSource {

    suspend fun getTicker(market: String): TickerEntity
}
