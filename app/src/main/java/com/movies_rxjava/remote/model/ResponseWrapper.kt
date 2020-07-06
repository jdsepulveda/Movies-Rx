package com.movies_rxjava.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val results: List<Movie>
)