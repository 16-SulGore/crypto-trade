package com.sulgorae.domain.entity.orders.chance

data class Bid(
    val currency: String,
    val min_total: Int,
    val price_unit: Any
)