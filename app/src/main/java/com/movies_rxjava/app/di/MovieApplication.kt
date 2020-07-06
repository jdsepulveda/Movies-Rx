package com.movies_rxjava.app.di

import android.app.Application

open class MovieApplication : Application() {
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}