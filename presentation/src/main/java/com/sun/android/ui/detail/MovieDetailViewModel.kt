package com.sun.android.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.domain.MovieRepository
import com.sun.data.model.Movie
import com.sun.android.utils.LogUtils
import com.sun.android.utils.livedata.SingleLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val movieRepository: com.sun.domain.MovieRepository) : ViewModel() {
    val movie = SingleLiveData<com.sun.data.model.Movie>()

    fun requestMovieDetails(movieId: Int) {
        viewModelScope.launch {
            movieRepository.getDetailMovies(movieId).catch {
                LogUtils.e("QQQQQ", it.toString())
            }.collect { movie.value = it }
        }
    }
}
