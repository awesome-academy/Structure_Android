package com.sun.data.repository

import com.sun.data.source.TokenDataSource
import com.sun.domain.repository.TokenRepository

class TokenRepositoryImpl(private val local: TokenDataSource.Local) :
    TokenRepository {

    override fun getToken() = local.getToken()

    override fun saveToken(token: String) = local.saveToken(token)

    override fun clearToken() = local.clearToken()
}
