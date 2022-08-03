package com.persadaditya.app.data.repository

import com.persadaditya.app.data.DataManager
import com.persadaditya.app.data.local.prefs.PreferencesHelper
import com.persadaditya.app.data.model.request.LoginReq
import com.persadaditya.app.data.model.response.LoginResponse
import com.persadaditya.app.data.model.response.MovieResponse
import com.persadaditya.app.data.model.response.SearchResponse
import com.persadaditya.app.data.remote.ApiHelper
import io.reactivex.Observable
import javax.inject.Inject

class AppRepo @Inject constructor(private val api: ApiHelper) : Repo{
    override fun login(req: LoginReq): Observable<LoginResponse> = api.login(req)

    override fun searchMovie(
        search: String,
        type: String?,
        year: Int?,
        page: Int?
    ): Observable<SearchResponse> = api.searchMovie(search, type, year, page)

    override fun detailMovie(movieId: String): Observable<MovieResponse> = api.detailMovie(movieId)
}