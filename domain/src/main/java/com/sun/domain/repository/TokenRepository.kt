package com.sun.domain.repository

interface TokenRepository {
    fun getToken(): String?

    fun saveToken(token: String)

    fun clearToken()
}
