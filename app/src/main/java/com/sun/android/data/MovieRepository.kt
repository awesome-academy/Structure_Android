package com.sun.android.data

import com.sun.android.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(): Flow<List<Movie>>

    fun getDetailMovies(movieId: Int): Flow<Movie>
}
