package com.iftah.core.data

import com.iftah.core.data.source.remote.RemoteDataSource
import com.iftah.core.data.source.remote.network.ApiResponse
import com.iftah.core.data.source.remote.response.MovieResponse
import com.iftah.core.domain.model.Movie
import com.iftah.core.domain.repository.IMovieRepository
import com.iftah.core.utils.AppExecutors
import com.iftah.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: com.iftah.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {

            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data.isNullOrEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()


            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }


        }.asFlow()

    override fun getTopRatedMovies(): Flow<List<Movie>> {
        return localDataSource.getTopRatedMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getPopularMovies(): Flow<List<Movie>> {
        return localDataSource.getPopularMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
    }

}