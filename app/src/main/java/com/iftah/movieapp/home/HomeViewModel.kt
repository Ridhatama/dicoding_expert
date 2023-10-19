package com.iftah.movieapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.iftah.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val allMovies = movieUseCase.getAllMovies().asLiveData()

    val topRatedMovies = movieUseCase.getTopRatedMovies().asLiveData()

    val popularMovies = movieUseCase.getPopularMovies().asLiveData()
}