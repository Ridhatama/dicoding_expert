package com.iftah.movieapp.di

import com.iftah.core.domain.usecase.MovieInteractor
import com.iftah.core.domain.usecase.MovieUseCase
import com.iftah.movieapp.detail.DetailMovieViewModel
import com.iftah.movieapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}
