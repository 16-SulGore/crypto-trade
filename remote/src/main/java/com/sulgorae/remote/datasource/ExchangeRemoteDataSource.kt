package com.sulgorae.remote.datasource

import com.sulgorae.domain.datasource.ExchangeDataSource
import com.sulgorae.domain.entity.Account
import com.sulgorae.remote.service.AccountsService

class ExchangeRemoteDataSource(private val accountsService: AccountsService) : ExchangeDataSource {

    override suspend fun getAccounts() = runCatching {
        accountsService.getAccounts()
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(listOf(defaultAccount))

    companion object {
        val defaultAccount = Account(currency = "", balance = 0.0, unitCurrency = "")
    }
}
