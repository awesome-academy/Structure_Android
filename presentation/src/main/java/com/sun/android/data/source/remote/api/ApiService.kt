package com.sun.android.data.source.remote.api

import com.sun.android.data.model.Movie
import com.sun.android.data.source.remote.api.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated?")
    suspend fun getTopRateMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int = 1
    ): BaseResponse<List<Movie>>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String?
    ): Movie
}
