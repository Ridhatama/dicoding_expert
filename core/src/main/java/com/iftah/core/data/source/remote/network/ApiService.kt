package com.iftah.core.data.source.remote.network

import com.iftah.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("movie")
    suspend fun getAllMovies(): ListMovieResponse

}