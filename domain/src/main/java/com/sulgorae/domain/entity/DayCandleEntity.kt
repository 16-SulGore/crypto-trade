package com.sulgorae.domain.entity

data class DayCandleEntity(
    val market: String,
    val highPrice: Double,
    val lowPrice: Double,
    val tradePrice: Double,
    val prevClosingPrice: Double
)
