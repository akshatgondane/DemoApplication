package com.example.demoapplication.repository.api

import com.example.demoapplication.repository.models.User
import retrofit2.http.GET

interface UserApiService
{
    @GET("users")
    suspend fun getUsers(): List<User>

}