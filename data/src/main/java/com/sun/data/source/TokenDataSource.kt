package com.sun.data.source

interface TokenDataSource {
    interface Local {
        fun getToken(): String?

        fun saveToken(token: String)

        fun clearToken()
    }

    interface Remote
}
