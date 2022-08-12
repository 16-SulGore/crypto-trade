package com.sulgorae.domain.datasource

import com.sulgorae.domain.entity.Account

interface ExchangeDataSource {

    suspend fun getAccounts(): List<Account>
}
