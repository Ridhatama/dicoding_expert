package com.iftah.core.data.source.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class MovieResponse(

    @field:SerializedName("id")
    val moviesId: Int,

    @field:SerializedName("title")
    val movieName: String,

    @field:SerializedName("overview")
    val description: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("poster_path")
    val poster: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("backdrop_path")
    var backdropPoster: String,

    @field:SerializedName("isFavorite")
    val isFavorite: Boolean
)
