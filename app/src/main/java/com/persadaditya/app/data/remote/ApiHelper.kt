package com.persadaditya.app.data.remote

import com.persadaditya.app.data.model.request.LoginReq
import com.persadaditya.app.data.model.response.LoginResponse
import com.persadaditya.app.data.model.response.MovieResponse
import com.persadaditya.app.data.model.response.SearchResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by M.Enes on 5/8/2019
 */
interface ApiHelper {

    @POST("users/authtoken")
    fun login(@Body req:LoginReq): Observable<LoginResponse>


    @GET("?apikey=ad0797bb")
    fun searchMovie(@Query("s") search:String,
                    @Query("type") type:String?,
                    @Query("y") year: Int?,
                    @Query("page") page: Int?
                    ) : Observable<SearchResponse>


    @GET("?apikey=ad0797bb")
    fun detailMovie(@Query("i") movieId:String, ) : Observable<MovieResponse>
}