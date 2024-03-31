package com.sun.data.source.remote.api

import com.sun.data.entities.MovieData
import com.sun.data.source.remote.api.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated?")
    suspend fun getTopRateMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int = 1
    ): BaseResponse<List<MovieData>>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String?
    ): com.sun.data.entities.MovieData
}
