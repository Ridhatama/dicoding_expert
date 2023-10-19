package com.iftah.core.domain.repository

import com.iftah.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<com.iftah.core.data.Resource<List<Movie>>>

    fun getTopRatedMovies(): Flow<List<Movie>>

    fun getPopularMovies(): Flow<List<Movie>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}