package com.sulgorae.crypto.utils

import com.sulgorae.domain.entity.accounts.Accounts
import com.sulgorae.data.entity.ticker.Ticker

// 원화 기준
fun Accounts.getTotalAccount(ticker: com.sulgorae.data.entity.ticker.Ticker) = fold(0.0) { acc, accountsItem ->
    acc + when (accountsItem.currency) {
        "KRW" -> accountsItem.balance.toDouble()
        else -> accountsItem.balance.toDouble() * ticker.first { tickerItem -> tickerItem.market.substring(4) == accountsItem.currency}.trade_price
    }
}
