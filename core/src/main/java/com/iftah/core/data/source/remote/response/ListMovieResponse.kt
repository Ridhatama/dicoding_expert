package com.iftah.core.data.source.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class ListMovieResponse(

    @field:SerializedName("results")
    val results: List<MovieResponse>
)