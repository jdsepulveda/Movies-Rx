package com.movies_rxjava.app.di

import android.content.Context
import com.movies_rxjava.app.ui.FragmentLatestMovies
import com.movies_rxjava.app.ui.FragmentPopularMovies
import com.movies_rxjava.app.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PresentationModule::class,
        RemoteSourceModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: FragmentPopularMovies)
    fun inject(fragment: FragmentLatestMovies)
}