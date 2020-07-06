package com.movies_rxjava.app.viewmodels

import androidx.lifecycle.ViewModel
import com.movies_rxjava.source.RemoteDataSource
import javax.inject.Inject

class FragmentLatestMoviesVM @Inject constructor(
private val remoteDataSource: RemoteDataSource
) : ViewModel() {

//    fun algo() {
//        remoteDataSource.getPopularMovies()
//    }

}