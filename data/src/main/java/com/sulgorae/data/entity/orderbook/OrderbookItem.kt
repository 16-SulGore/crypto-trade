package com.sulgorae.data.entity.orderbook

data class OrderbookItem(
    val market: String,
    val orderbook_units: List<OrderbookUnit>,
    val timestamp: Long,
    val total_ask_size: Double,
    val total_bid_size: Double
)