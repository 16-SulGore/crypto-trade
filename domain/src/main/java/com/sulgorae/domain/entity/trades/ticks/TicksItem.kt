package com.sulgorae.domain.entity.trades.ticks

data class TicksItem(
    val ask_bid: String,
    val chane_price: Int,
    val market: String,
    val prev_closing_price: Int,
    val timestamp: Long,
    val trade_date_utc: String,
    val trade_price: Int,
    val trade_time_utc: String,
    val trade_volume: Double
)