package com.sylvinatests.jetpackkcomposeinstagram.domain

import com.sylvinatests.jetpackkcomposeinstagram.data.LoginRepository

class LoginUseCase {

    private val repository =  LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user = user, password = password)
    }

}