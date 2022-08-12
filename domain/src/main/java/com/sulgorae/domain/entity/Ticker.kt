package com.sulgorae.domain.entity

data class Ticker (
    val market: String,
    val openingPrice: Double,
    val highPrice: Double,
    val tradePrice: Double,
    val prevClosingPrice: Double
)
