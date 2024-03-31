package com.sun.android.data.repository

import com.sun.android.data.TokenRepository
import com.sun.android.data.source.TokenDataSource

class TokenRepositoryImpl(private val local: TokenDataSource.Local) :
    TokenRepository {

    override fun getToken() = local.getToken()

    override fun saveToken(token: String) = local.saveToken(token)

    override fun clearToken() = local.clearToken()
}
