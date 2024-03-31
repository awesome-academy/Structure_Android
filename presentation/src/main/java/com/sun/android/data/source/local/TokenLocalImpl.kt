package com.sun.android.data.source.local

import com.sun.android.data.source.TokenDataSource
import com.sun.android.data.source.local.api.SharedPrefsApi
import com.sun.android.data.source.local.api.sharedpref.SharedPrefsKey

class TokenLocalImpl(private val sharedPrefApi: SharedPrefsApi) :
    TokenDataSource.Local {

    override fun getToken() =
        sharedPrefApi.get(SharedPrefsKey.KEY_TOKEN, String::class.java)

    override fun saveToken(token: String) =
        sharedPrefApi.put(SharedPrefsKey.KEY_TOKEN, token)

    override fun clearToken() = sharedPrefApi.removeKey(SharedPrefsKey.KEY_TOKEN)
}
