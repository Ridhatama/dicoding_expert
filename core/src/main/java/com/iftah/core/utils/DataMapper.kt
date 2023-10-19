package com.iftah.core.utils

import com.iftah.core.data.source.local.entity.MovieEntity
import com.iftah.core.data.source.remote.response.MovieResponse
import com.iftah.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()

        input.map {
            val movie = MovieEntity(
                movieId = it.moviesId,
                description = it.description,
                movieName = it.movieName,
                poster = it.poster,
                voteAverage = it.voteAverage,
                popularity = it.popularity,
                backdropPoster = it.backdropPoster,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =

        input.map {
            Movie(
                movieId = it.movieId,
                description = it.description,
                movieName = it.movieName,
                poster = it.poster,
                voteAverage = it.voteAverage,
                popularity = it.popularity,
                backdropPoster = it.backdropPoster,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        description = input.description,
        movieName = input.movieName,
        poster = input.poster,
        voteAverage = input.voteAverage,
        popularity = input.popularity,
        backdropPoster = input.backdropPoster,
        isFavorite = input.isFavorite
    )
}