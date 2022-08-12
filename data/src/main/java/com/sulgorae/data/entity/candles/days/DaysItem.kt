package com.sulgorae.data.entity.candles.days

data class DaysItem(
    val candle_acc_trade_price: Double,
    val candle_acc_trade_volume: Double,
    val candle_date_time_kst: String,
    val candle_date_time_utc: String,
    val change_price: Int,
    val change_rate: Double,
    val high_price: Int,
    val low_price: Int,
    val market: String,
    val opening_price: Int,
    val prev_closing_price: Int,
    val timestamp: Long,
    val trade_price: Int
)