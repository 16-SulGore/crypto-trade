package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.domain.entity.Ticker
import com.sulgorae.remote.service.TickerService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import io.mockk.coEvery
import io.mockk.mockk

internal class QuotationRemoteDataSourceTest : BehaviorSpec() {

    private val tickerService = mockk<TickerService>(relaxUnitFun = true)

    private val quotationDataSource: QuotationDataSource = QuotationRemoteDataSource(tickerService)

    init {
        Given("Quotation Data Source") {
            val mockTicker = mutableListOf<Ticker>()
            mockTicker.add( Ticker(
                market = "KRW-BTC",
                openingPrice = 0.0,
                highPrice = 0.0, tradePrice = 0.0, prevClosingPrice = 0.0

            ))

            When("자산을 조회할 때 올바르게 호출되면") {
                coEvery { tickerService.getTicker("KRW-BTC") } returns mockTicker[0]

                val ticker = quotationDataSource.getTicker("KRW-BTC")

                Then("자산이 그대로 반환된다.") {
                    ticker shouldBe mockTicker
                }
            }

            When("자산을 조회할 때 올바르지 않게 호출되면") {
                val errorMessage = "ERROR"
                coEvery { tickerService.getTicker("KRW-BTC") } throws IllegalStateException(errorMessage)

                val except = shouldThrow <IllegalStateException> {
                    quotationDataSource.getTicker("KRW-BTC")
                }

                Then("에러가 발생한다.") {
                    except.message shouldStartWith errorMessage
                }
            }
        }
    }
}
