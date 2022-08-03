package com.persadaditya.app.data.repository


import com.persadaditya.app.data.model.response.MovieResponse
import com.persadaditya.app.data.model.response.SearchResponse
import com.persadaditya.app.data.remote.ApiHelper
import io.reactivex.Observable
import javax.inject.Inject

class AppRepo @Inject constructor(private val api: ApiHelper) : Repo{

    override fun searchMovie(
        search: String,
        type: String?,
        year: Int?,
        page: Int?
    ): Observable<SearchResponse> = api.searchMovie(search, type, year, page)

    override fun detailMovie(movieId: String): Observable<MovieResponse> = api.detailMovie(movieId)
}