package com.example.demoapplication.repository.api

import com.example.demoapplication.repository.models.User

class UserApiHelper(private val userApiService: UserApiService): UserApiService
{
    override suspend fun getUsers(): List<User>
    {
        return userApiService.getUsers()
    }
}