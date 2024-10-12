package com.sylvinatests.jetpackkcomposeinstagram.data.network

import com.sylvinatests.jetpackkcomposeinstagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(ApiService::class.java).doLogin()
            response.body()?.success ?: false
        }
    }

}