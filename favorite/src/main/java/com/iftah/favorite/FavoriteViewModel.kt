package com.iftah.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.iftah.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {

    val getFavoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}