package com.movies_rxjava.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.movies_rxjava.BuildConfig
import com.movies_rxjava.app.utils.Event
import com.movies_rxjava.app.utils.EventTypes
import com.movies_rxjava.app.utils.Resource
import com.movies_rxjava.remote.model.Movie
import com.movies_rxjava.source.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FragmentPopularMoviesVM @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val popularMoviesList = MutableLiveData<Resource<List<Movie>>>()
    val popularMovies: LiveData<Resource<List<Movie>>>
        get() = popularMoviesList

    private val eventTypes = MutableLiveData<Event<EventTypes>>()
    val event: LiveData<Event<EventTypes>>
        get() = eventTypes

    init {
        popularMoviesList.postValue(Resource.loading())
        disposable.add(
            remoteDataSource.getPopularMovies(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { movies -> popularMoviesList.postValue(Resource.success(movies.results)) },
                    { popularMoviesList.postValue(Resource.error(it.localizedMessage)) }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}