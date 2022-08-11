package com.sulgorae.crypto.utils

import com.sulgorae.domain.entity.Account
import com.sulgorae.domain.entity.Ticker
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec() {

    init {
        Given("Calculator") {
            val mockAccounts = mutableListOf<Account>()

            mockAccounts.add( Account(
                currency = "BTC",
                balance = 1.0,
            ))

            mockAccounts.add( Account(
                currency = "KRW",
                balance = 20000.0,
            ))

            val mockTicker = Ticker()
//            mockTicker.add( TickerItem(acc_trade_price = 0.0,
//                acc_trade_price_24h = 0.0,
//                acc_trade_volume = 0.0,
//                acc_trade_volume_24h = 0.0,
//                change = "",
//                change_price = 0,
//                change_rate = 0.0,
//                high_price = 0,
//                highest_52_week_date = "",
//                highest_52_week_price = 0,
//                low_price = 0,
//                lowest_52_week_date = "",
//                lowest_52_week_price = 0,
//                market = "KRW-BTC",
//                opening_price = 0,
//                prev_closing_price = 0,
//                signed_change_price = 0,
//                signed_change_rate = 0.0,
//                timestamp = 0,
//                trade_date = "",
//                trade_date_kst = "",
//                trade_price = 100,
//                trade_time = "",
//                trade_time_kst = "",
//                trade_timestamp = 0,
//                trade_volume = 0.0
//            ))

            When("원화만 20000 있을 때") {
                val onlyKrwAccounts = mutableListOf<Account>()
                onlyKrwAccounts.add(mockAccounts[1])

                val totalAccount = getTotalAccount(onlyKrwAccounts)

                Then("20000원이 집계된다.") {
                    totalAccount shouldBe 20000
                }
            }

            When("원화 20000원, BTC 1개가 있을 때") {
                val krwAndBtcAccounts = mockAccounts
                val totalAccount = getTotalAccount(krwAndBtcAccounts)

                Then("20100원이 집계된다.") {
                    totalAccount shouldBe 20100
                }
            }
        }
    }
}
