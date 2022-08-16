package com.sulgorae.domain.datasource

import com.sulgorae.domain.entity.DayCandleEntity
import com.sulgorae.domain.entity.TickerEntity

interface QuotationDataSource {

    suspend fun getTicker(market: String): TickerEntity

    suspend fun getDayCandle(market: String): DayCandleEntity

    suspend fun getDayCandleWithPeriod(market: String, to: String): DayCandleEntity
}
