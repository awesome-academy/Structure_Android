package com.sun.data.source

import com.sun.data.entities.MovieRemote
import com.sun.data.entities.MovieLocal
import com.sun.data.source.remote.api.response.BaseResponse

interface MovieDataSource {
    /**
     * Local
     */
    interface Local {
        suspend fun getMoviesLocal(): List<MovieLocal>
        suspend fun updateMovies(movies: List<MovieLocal>)
        suspend fun getMovieDetailLocal(movieId: Int): MovieLocal
    }

    /**
     * Remote
     */
    interface Remote {
        suspend fun getMovies(): BaseResponse<List<MovieRemote>>

        suspend fun getMovieDetail(movieId: Int): MovieRemote
    }
}
