package com.sun.data.source.local

import com.sun.data.source.MovieDataSource
import com.sun.data.source.local.room.MovieDao

class MovieLocalImpl(private val movieDao: MovieDao) : MovieDataSource.Local {
    override suspend fun getMoviesLocal(): List<com.sun.data.entities.MovieData> {
        return movieDao.getAllMovies()
    }

    override suspend fun updateMovies(movies: List<com.sun.data.entities.MovieData>) {
        return movieDao.insert(movies)
    }

    override suspend fun getMovieDetailLocal(movieId: Int): com.sun.data.entities.MovieData {
        return movieDao.getMovie(movieId)
    }
}
