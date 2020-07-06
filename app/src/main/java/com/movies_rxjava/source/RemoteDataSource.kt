package com.movies_rxjava.source

import com.movies_rxjava.remote.model.ResponseWrapper
import io.reactivex.Observable

interface RemoteDataSource {

    fun getPopularMovies(apiKey: String): Observable<ResponseWrapper>
}