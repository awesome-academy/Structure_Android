package com.sun.android.di

import com.sun.android.ui.MainViewModel
import com.sun.android.ui.detail.MovieDetailViewModel
import com.sun.android.ui.listmovie.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val ViewModelModule: Module = module {
    viewModel { MainViewModel() }
    viewModel { MoviesViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}
