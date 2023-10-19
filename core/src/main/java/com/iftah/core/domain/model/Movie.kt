package com.iftah.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val movieName: String,
    val description: String,
    val voteAverage: Double,
    val poster: String,
    val popularity: Double,
    val backdropPoster: String,
    val isFavorite: Boolean
) : Parcelable