package com.movies_rxjava.remote.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("video") val video: Boolean,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("genre_ids") val genreIds: List<Int>
)