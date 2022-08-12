package com.sulgorae.data.entity.order

data class Trade(
    val funds: String,
    val market: String,
    val price: String,
    val side: String,
    val uuid: String,
    val volume: String
)