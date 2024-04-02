package com.sun.data.repository

import android.util.Log
import com.sun.data.entities.MovieLocal
import com.sun.data.source.MovieDataSource
import com.sun.domain.entities.MovieEntity
import com.sun.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import java.io.IOException

class MovieRepositoryImpl(
    private val remote: MovieDataSource.Remote,
    private val local: MovieDataSource.Local
) : KoinComponent, MovieRepository {

    override suspend fun getMovies(): Flow<List<MovieEntity>> = flow {
        val movies = arrayListOf<MovieEntity>()
        try {
            val movieDts = remote.getMovies().data
            movieDts.forEach {
                movies.add(it.mapToEntity())
            }

            val movieDbs = arrayListOf<MovieLocal>()
            movieDts.forEach {
                movieDbs.add(it.mapToLocal())
            }
            local.updateMovies(movieDbs)
        } catch (e: IOException) {
            val moviesDbs = local.getMoviesLocal()
            Log.e("MovieRepository", "getMovies failed, using local data \n Detail error:\n $e")
        }
        emit(movies)
    }

    override suspend fun getDetailMovies(movieId: Int): Flow<MovieEntity> = flow {
        try {
            emit(local.getMovieDetailLocal(movieId).mapToEntity())
        } catch (e: IOException) {
            Log.e("MovieRepository", "getDetailMovies failed, retry with network \n Detail error:\n $e")
            val movieRemote = remote.getMovieDetail(movieId = movieId)
            local.updateMovies(arrayListOf(movieRemote.mapToLocal()))
            emit(movieRemote.mapToEntity())
        }
    }
}
