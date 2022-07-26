package com.sulgorae.domain.entity.orders.chance

data class Market(
    val ask: Ask,
    val bid: Bid,
    val id: String,
    val max_total: String,
    val name: String,
    val order_sides: List<String>,
    val order_types: List<String>,
    val state: String
)