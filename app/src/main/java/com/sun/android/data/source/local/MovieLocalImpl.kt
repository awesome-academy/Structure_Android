package com.sun.android.data.source.local

import com.sun.android.data.model.Movie
import com.sun.android.data.source.MovieDataSource
import com.sun.android.data.source.local.room.MovieDao

class MovieLocalImpl(private val movieDao: MovieDao) : MovieDataSource.Local {
    override suspend fun getMoviesLocal(): List<Movie> {
        return movieDao.getAllMovies()
    }

    override suspend fun updateMovies(movies: List<Movie>) {
        return movieDao.insert(movies)
    }

    override suspend fun getMovieDetailLocal(movieId: Int): Movie {
        return movieDao.getMovie(movieId)
    }
}
