package com.sulgorae.data.entity.orderbook

data class OrderbookUnit(
    val ask_price: Int,
    val ask_size: Double,
    val bid_price: Int,
    val bid_size: Double
)