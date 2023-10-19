package com.iftah.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var movieName: String,

    @ColumnInfo(name = "overview")
    var description: String,

    @ColumnInfo(name = "vote_average")
    var voteAverage: Double,

    @ColumnInfo(name = "poster_path")
    var poster: String,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "backdrop_path")
    var backdropPoster: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

)