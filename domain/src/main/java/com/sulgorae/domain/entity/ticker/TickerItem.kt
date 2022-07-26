package com.sulgorae.domain.entity.ticker

data class TickerItem(
    val acc_trade_price: Double,
    val acc_trade_price_24h: Double,
    val acc_trade_volume: Double,
    val acc_trade_volume_24h: Double,
    val change: String,
    val change_price: Int,
    val change_rate: Double,
    val high_price: Int,
    val highest_52_week_date: String,
    val highest_52_week_price: Int,
    val low_price: Int,
    val lowest_52_week_date: String,
    val lowest_52_week_price: Int,
    val market: String,
    val opening_price: Int,
    val prev_closing_price: Int,
    val signed_change_price: Int,
    val signed_change_rate: Double,
    val timestamp: Long,
    val trade_date: String,
    val trade_date_kst: String,
    val trade_price: Int,
    val trade_time: String,
    val trade_time_kst: String,
    val trade_timestamp: Long,
    val trade_volume: Double
)