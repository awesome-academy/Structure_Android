package com.sun.data.source.remote.api.error

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.android.utils.LogUtils
import com.sun.android.utils.extension.notNull
import java.io.IOException
import java.text.ParseException
import retrofit2.HttpException

data class ErrorResponse(
    @SerializedName("status")
    @Expose
    val status: Int,
    @SerializedName("messages")
    @Expose
    val messages: String?
) {
    companion object {
        private const val TAG = "ErrorResponse"

        fun convertToRetrofitException(throwable: Throwable): RetrofitException {
            if (throwable is RetrofitException) {
                return throwable
            }

            // A network error happened
            if (throwable is IOException) {
                return RetrofitException.toNetworkError(throwable)
            }

            // We had non-200 http error
            if (throwable is HttpException) {
                val response = throwable.response() ?: return RetrofitException.toUnexpectedError(
                    throwable
                )

                response.errorBody().notNull {
                    return try {
                        val errorResponse =
                            Gson().fromJson(it.string(), ErrorResponse::class.java)

                        if (errorResponse != null && !errorResponse.messages.isNullOrBlank()) {
                            RetrofitException.toServerError(errorResponse)
                        } else {
                            RetrofitException.toHttpError(response)
                        }
                    } catch (e: IOException) {
                        LogUtils.e(TAG, e.message.toString())
                        RetrofitException.toUnexpectedError(throwable)
                    } catch (e: ParseException) {
                        LogUtils.e(TAG, e.message.toString())
                        RetrofitException.toUnexpectedError(throwable)
                    } catch (e: JsonSyntaxException) {
                        LogUtils.e(TAG, e.message.toString())
                        RetrofitException.toUnexpectedError(throwable)
                    }
                }

                return RetrofitException.toHttpError(response)
            }

            // We don't know what happened. We need to simply convert to an unknown error
            return RetrofitException.toUnexpectedError(throwable)
        }
    }
}
