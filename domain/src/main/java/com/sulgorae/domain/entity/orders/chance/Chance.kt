package com.sulgorae.domain.entity.orders.chance

data class Chance(
    val ask_account: AskAccount,
    val ask_fee: String,
    val bid_account: BidAccount,
    val bid_fee: String,
    val market: Market
)