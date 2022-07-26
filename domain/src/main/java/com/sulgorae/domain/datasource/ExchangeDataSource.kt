package com.sulgorae.domain.datasource

import com.sulgorae.domain.entity.accounts.Accounts

interface ExchangeDataSource {

    fun getAccounts(): Accounts
}
