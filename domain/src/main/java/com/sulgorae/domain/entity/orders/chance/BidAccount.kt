package com.sulgorae.domain.entity.orders.chance

data class BidAccount(
    val avg_buy_price: String,
    val avg_buy_price_modified: Boolean,
    val balance: String,
    val currency: String,
    val locked: String,
    val unit_currency: String
)