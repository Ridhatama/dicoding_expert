package com.iftah.core.domain.usecase

import com.iftah.core.domain.model.Movie
import com.iftah.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getAllMovies() = movieRepository.getAllMovies()

    override fun getTopRatedMovies() = movieRepository.getTopRatedMovies()

    override fun getPopularMovies() = movieRepository.getPopularMovies()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)

}