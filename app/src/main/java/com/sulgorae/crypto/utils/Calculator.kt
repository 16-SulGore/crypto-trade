package com.sulgorae.crypto.utils

import com.sulgorae.domain.entity.Account

// 원화 기준
fun getTotalAccount(accounts: List<Account>): Double = accounts.fold(0.0) { acc, account ->
    acc + when (account.currency) {
        "KRW" -> account.balance
        else -> 0.0
//           TODO: else -> account.balance * ticker[account.currency]
    }
}

//private fun getCurrentPrice(market: String) =

//fun Account.getTotalAccount(ticker: Ticker) = fold(0.0) { acc, accountsItem ->
//    acc + when (accountsItem.currency) {
//        "KRW" -> accountsItem.balance.toDouble()
//        else -> accountsItem.balance.toDouble() * ticker.first { tickerItem -> tickerItem.market.substring(4) == accountsItem.currency}.trade_price
//    }
//}
