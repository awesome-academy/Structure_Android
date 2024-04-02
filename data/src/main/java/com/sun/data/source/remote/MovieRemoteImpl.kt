package com.sun.data.source.remote

import com.sun.android.BuildConfig
import com.sun.data.entities.MovieRemote
import com.sun.data.source.MovieDataSource
import com.sun.data.source.remote.api.ApiService
import com.sun.data.source.remote.api.response.BaseResponse

class MovieRemoteImpl(private val apiService: ApiService) : MovieDataSource.Remote {
    override suspend fun getMovies(): BaseResponse<List<MovieRemote>> {
        return apiService.getTopRateMovies(apiKey = BuildConfig.API_KEY)
    }

    override suspend fun getMovieDetail(movieId: Int): com.sun.data.entities.MovieRemote {
        return apiService.getMovieDetails(movieId = movieId, apiKey = BuildConfig.API_KEY)
    }
}
