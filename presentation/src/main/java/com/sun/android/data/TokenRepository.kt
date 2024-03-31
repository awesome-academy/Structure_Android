package com.sun.android.data

interface TokenRepository {
    fun getToken(): String?

    fun saveToken(token: String)

    fun clearToken()
}
