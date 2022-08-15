package com.sulgorae.data.entity.ticker

import com.sulgorae.domain.entity.TickerEntity

class Ticker : ArrayList<TickerItem>() {

    fun toEntities() = map { tickerItem ->
        with (tickerItem) {
            TickerEntity(
                market = market,
                openingPrice = opening_price.toDouble(),
                highPrice = high_price.toDouble(),
                tradePrice = trade_price.toDouble(),
                prevClosingPrice = prev_closing_price.toDouble()
            )
        }
    }
}
