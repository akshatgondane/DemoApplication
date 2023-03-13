package com.example.demoapplication.repository.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapplication.repository.api.RetrofitBuilder
import com.example.demoapplication.repository.api.UserApiHelper
import com.example.demoapplication.repository.models.User
import kotlinx.coroutines.launch

class UserViewModel: ViewModel()
{
    var userListResponse: List<User> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getUserList()
    {
        viewModelScope.launch {
            val userApiService = RetrofitBuilder.getRetrofit()
            val userApiHelper = UserApiHelper(userApiService)
            try {
                val userList = userApiHelper.getUsers()
                userListResponse = userList
            }
            catch (e: java.lang.Exception)
            {
                errorMessage = e.message.toString()
            }
        }
    }
}