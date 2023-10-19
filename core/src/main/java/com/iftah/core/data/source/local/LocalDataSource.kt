package com.iftah.core.data.source.local

import com.iftah.core.data.source.local.entity.MovieEntity
import com.iftah.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getTopRatedMovies(): Flow<List<MovieEntity>> = movieDao.getTopRatedMovies()

    fun getPopularMovies(): Flow<List<MovieEntity>> = movieDao.getPopularMovies()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

}