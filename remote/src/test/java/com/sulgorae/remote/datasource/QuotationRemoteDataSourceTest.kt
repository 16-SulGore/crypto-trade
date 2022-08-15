package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.QuotationDataSource
import com.sulgorae.domain.entity.TickerEntity
import com.sulgorae.remote.service.QuotationService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import io.mockk.coEvery
import io.mockk.mockk

internal class QuotationRemoteDataSourceTest : BehaviorSpec() {

    private val tickerService = mockk<QuotationService>(relaxUnitFun = true)

    private val quotationDataSource: QuotationDataSource = QuotationRemoteDataSource(tickerService)

    init {
        Given("Quotation Data Source") {
            val mockTickerEntity = mutableListOf<TickerEntity>()
            mockTickerEntity.add( TickerEntity(
                market = "KRW-BTC",
                openingPrice = 0.0,
                highPrice = 0.0, tradePrice = 0.0, prevClosingPrice = 0.0

            ))

            When("자산을 조회할 때 올바르게 호출되면") {
                coEvery { tickerService.getTicker("KRW-BTC") } returns mockTickerEntity[0]

                val ticker = quotationDataSource.getTicker("KRW-BTC")

                Then("자산이 그대로 반환된다.") {
                    ticker shouldBe mockTickerEntity
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
