package com.sulgorae.data.entity.candles.days

import com.sulgorae.domain.entity.DayCandleEntity

class Days : ArrayList<DaysItem>() {

    fun toEntities() = map { daysItem ->
        with (daysItem) {
            DayCandleEntity(
                market = market,
                highPrice = high_price.toDouble(),
                lowPrice = low_price.toDouble(),
                tradePrice = trade_price.toDouble(),
                prevClosingPrice = prev_closing_price.toDouble()
            )
        }
    }
}
