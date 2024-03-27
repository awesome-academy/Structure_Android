package com.sun.android.data.source

import com.sun.android.data.model.Movie
import com.sun.android.data.source.remote.api.response.BaseResponse

interface MovieDataSource {
    /**
     * Local
     */
    interface Local {
        suspend fun getMoviesLocal(): List<Movie>
        suspend fun updateMovies(movies: List<Movie>)
    }

    /**
     * Remote
     */
    interface Remote {
        suspend fun getMovies(): BaseResponse<List<Movie>>

        suspend fun getMovieDetail(movieId: Int): Movie
    }
}
