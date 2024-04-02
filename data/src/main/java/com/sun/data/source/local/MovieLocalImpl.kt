package com.sun.data.source.local

import com.sun.data.entities.MovieLocal
import com.sun.data.source.MovieDataSource
import com.sun.data.source.local.room.MovieDao

class MovieLocalImpl(private val movieDao: MovieDao) : MovieDataSource.Local {
    override suspend fun getMoviesLocal(): List<MovieLocal> {
        return movieDao.getAllMovies()
    }

    override suspend fun updateMovies(movies: List<MovieLocal>) {
        return movieDao.insert(movies)
    }

    override suspend fun getMovieDetailLocal(movieId: Int): MovieLocal {
        return movieDao.getMovie(movieId)
    }
}
