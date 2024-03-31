package com.sun.domain.repository

import com.sun.domain.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(): Flow<List<MovieEntity>>

    suspend fun getDetailMovies(movieId: Int): Flow<MovieEntity>
}
