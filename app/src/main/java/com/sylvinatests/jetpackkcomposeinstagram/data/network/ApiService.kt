package com.sylvinatests.jetpackkcomposeinstagram.data.network

import com.sylvinatests.jetpackkcomposeinstagram.common.Constants
import com.sylvinatests.jetpackkcomposeinstagram.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.LOGIN_ENDPOINT)
    suspend fun doLogin(): Response<LoginResponse>
}