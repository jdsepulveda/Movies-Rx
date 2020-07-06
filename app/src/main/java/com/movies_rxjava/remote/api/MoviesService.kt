package com.movies_rxjava.remote.api

import com.movies_rxjava.remote.model.ResponseWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<ResponseWrapper>
}