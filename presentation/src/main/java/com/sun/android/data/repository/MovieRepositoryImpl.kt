package com.sun.android.data.repository

import android.util.Log
import com.sun.android.data.MovieRepository
import com.sun.android.data.model.Movie
import com.sun.android.data.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import java.io.IOException

class MovieRepositoryImpl(
    private val remote: MovieDataSource.Remote,
    private val local: MovieDataSource.Local
) : KoinComponent, MovieRepository {

    override suspend fun getMovies(): Flow<List<Movie>> = flow {
        try {
            val movies = remote.getMovies().data
            local.updateMovies(movies)
        } catch (e: IOException) {
            Log.e("MovieRepository", "getMovies failed, using local data \n Detail error:\n $e")
        }
        emit(local.getMoviesLocal())
    }

    override suspend fun getDetailMovies(movieId: Int) = flow {
        try {
            emit(local.getMovieDetailLocal(movieId))
        } catch (e: IOException) {
            Log.e("MovieRepository", "getDetailMovies failed, retry with network \n Detail error:\n $e")
            val movie = remote.getMovieDetail(movieId = movieId)
            local.updateMovies(arrayListOf(movie))
            emit(local.getMovieDetailLocal(movieId))
        }
    }
}
