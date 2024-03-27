package com.sun.android.ui.listmovie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.android.data.MovieRepository
import com.sun.android.data.model.Movie
import com.sun.android.utils.LogUtils
import com.sun.android.utils.dispatchers.DispatcherProvider
import com.sun.android.utils.livedata.SingleLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val movies = SingleLiveData<List<Movie>>()

    fun requestTopRateMovies() {
        val exceptionHandler = CoroutineExceptionHandler { context, error ->
            // Do what you want with the error
            Log.e("TAG", error.toString())
        }

        val supervisor = SupervisorJob()

        viewModelScope.launch(exceptionHandler + supervisor) {
            movieRepository.getMovies().catch { e ->
                LogUtils.e("QQQQQ", e.toString())
            }.flowOn(DispatcherProvider().io())
                .collect {
                    movies.value = it
                }
        }
    }
}
