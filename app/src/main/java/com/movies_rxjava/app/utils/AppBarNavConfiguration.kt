package com.movies_rxjava.app.utils

import androidx.navigation.ui.AppBarConfiguration
import com.movies_rxjava.R

private val topLevelIdsDestination: Set<Int> = setOf(
    R.id.fragmentPopularMovies,
    R.id.fragmentLatestMovies
)
val appBarNavConfiguration = AppBarConfiguration(topLevelIdsDestination)