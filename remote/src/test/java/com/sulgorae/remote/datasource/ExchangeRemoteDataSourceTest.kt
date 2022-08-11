package com.sulgorae.remote.datasource

import com.sulgorae.domain.entity.Account
import com.sulgorae.remote.service.AccountsService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import io.mockk.coEvery
import io.mockk.mockk

internal class ExchangeRemoteDataSourceTest : BehaviorSpec() {

    private val accountsService = mockk<AccountsService>(relaxUnitFun = true)

    private val exchangeDataSource = ExchangeRemoteDataSource(accountsService)

    init {
        Given("Exchange Data Source") {
            val mockAccounts = mutableListOf<Account>()
            mockAccounts.add( Account(
                currency = "BTC",
                balance = 1.0,
            ))

            When("자산을 조회할 때 올바르게 호출되면") {
                coEvery { accountsService.getAccounts() } returns mockAccounts

                val accounts = exchangeDataSource.getAccounts()

                Then("자산이 그대로 반환된다.") {
                    accounts shouldBe mockAccounts
                }
            }

            When("자산을 조회할 때 올바르지 않게 호출되면") {
                val errorMessage = "ERROR"
                coEvery { accountsService.getAccounts() } throws IllegalStateException(errorMessage)

                val except = shouldThrow <IllegalStateException> {
                    exchangeDataSource.getAccounts()
                }

                Then("에러가 발생한다.") {
                    except.message shouldStartWith errorMessage
                }
            }
        }
    }
}
