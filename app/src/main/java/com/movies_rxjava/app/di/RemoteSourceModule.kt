package com.movies_rxjava.app.di

import com.movies_rxjava.BuildConfig
import com.movies_rxjava.remote.api.MoviesService
import com.movies_rxjava.source.RemoteDataSource
import com.movies_rxjava.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [RemoteSourceModule.Binders::class])
class RemoteSourceModule {

    @Module
    interface Binders {
        @Binds
        fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
    }

    @Provides
    fun providesMoviesService(retrofit: Retrofit): MoviesService = retrofit.create(MoviesService::class.java)

    @Provides
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
}