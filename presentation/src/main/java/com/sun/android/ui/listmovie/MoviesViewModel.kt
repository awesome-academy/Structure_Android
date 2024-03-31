package com.sun.android.ui.listmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.domain.MovieRepository
import com.sun.data.model.Movie
import com.sun.android.utils.LogUtils
import com.sun.android.utils.dispatchers.DispatcherProvider
import com.sun.android.utils.livedata.SingleLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: com.sun.domain.MovieRepository) : ViewModel() {
    val movies = SingleLiveData<List<com.sun.data.model.Movie>>()

    fun requestTopRateMovies() {
        viewModelScope.launch {
            movieRepository.getMovies().catch { e ->
                LogUtils.e("requestTopRateMovies", e.toString())
            }.flowOn(DispatcherProvider().io())
                .collect {
                    movies.value = it
                }
        }
    }
}
