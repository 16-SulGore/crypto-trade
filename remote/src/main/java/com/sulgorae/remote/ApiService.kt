package com.sulgorae.remote

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object ApiService {

    private const val BASE_URL = "https://api.upbit.com/v1" // TODO: v1을 빼야할수도

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val token = {
        val accessKey = "발급받은 Access key"
        val secretKey = "발급받은 Secret key"
        val algorithm: Algorithm = Algorithm.HMAC256(secretKey)
        val jwtToken = JWT.create()
            .withClaim("access_key", accessKey)
            .withClaim("nonce", UUID.randomUUID().toString())
            .sign(algorithm)

        "Bearer $jwtToken"
    }
}
