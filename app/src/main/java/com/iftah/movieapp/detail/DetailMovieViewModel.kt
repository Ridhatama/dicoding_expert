package com.iftah.movieapp.detail

import androidx.lifecycle.ViewModel
import com.iftah.core.domain.model.Movie
import com.iftah.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    fun setFavoriteMovie(movie: Movie, newState: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newState)
}