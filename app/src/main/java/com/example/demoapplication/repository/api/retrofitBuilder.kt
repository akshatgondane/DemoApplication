package com.example.demoapplication.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder
{
    private const val BASE_URL = "https://gorest.co.in/public/v2/"
    var userApiService: UserApiService? = null
    fun getRetrofit(): UserApiService {

        userApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(UserApiService::class.java)

        return userApiService!!


    }

    //val userApiService: UserApiService = getRetrofit().create(UserApiService::class.java)
}