package com.sylvinatests.jetpackkcomposeinstagram.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = apiService.doLogin()
            response.body()?.success ?: false
        }
    }

}