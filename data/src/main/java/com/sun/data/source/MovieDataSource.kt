package com.sun.data.source

import com.sun.data.source.remote.api.response.BaseResponse
import com.sun.domain.entities.MovieEntity

interface MovieDataSource {
    /**
     * Local
     */
    interface Local {
        suspend fun getMoviesLocal(): List<MovieEntity>
        suspend fun updateMovies(movies: List<MovieEntity>)
        suspend fun getMovieDetailLocal(movieId: Int): MovieEntity
    }

    /**
     * Remote
     */
    interface Remote {
        suspend fun getMovies(): BaseResponse<List<MovieEntity>>

        suspend fun getMovieDetail(movieId: Int): MovieEntity
    }
}
