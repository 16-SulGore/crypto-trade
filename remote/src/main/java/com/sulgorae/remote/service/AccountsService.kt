package com.sulgorae.remote.service

import com.sulgorae.domain.entity.accounts.Accounts
import retrofit2.http.GET

interface AccountsService {

    @GET("/accounts")
    suspend fun getAccounts(): Accounts
}