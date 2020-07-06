package com.movies_rxjava.source

import com.movies_rxjava.remote.api.MoviesService
import com.movies_rxjava.remote.model.ResponseWrapper
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : RemoteDataSource {

    override fun getPopularMovies(apiKey: String): Observable<ResponseWrapper> {
        return moviesService.getPopularMovies(apiKey)
    }
}