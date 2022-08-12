package com.sulgorae.data.entity.orders.chance

data class Ask(
    val currency: String,
    val min_total: Int,
    val price_unit: Any
)