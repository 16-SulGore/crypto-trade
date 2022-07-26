package com.sulgorae.domain.entity.orders

data class OrdersItem(
    val created_at: String,
    val executed_volume: String,
    val locked: String,
    val market: String,
    val ord_type: String,
    val paid_fee: String,
    val price: String,
    val remaining_fee: String,
    val remaining_volume: String,
    val reserved_fee: String,
    val side: String,
    val state: String,
    val trades_count: Int,
    val uuid: String,
    val volume: String
)