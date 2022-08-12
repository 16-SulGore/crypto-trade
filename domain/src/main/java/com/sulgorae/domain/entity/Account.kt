package com.sulgorae.domain.entity

data class Account(
    val currency: String,
    val balance: Double,
    val unitCurrency: String = "KRW"
)
