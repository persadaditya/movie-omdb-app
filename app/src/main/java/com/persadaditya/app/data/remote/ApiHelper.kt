package com.persadaditya.app.data.remote

import com.persadaditya.app.data.model.response.MovieResponse
import com.persadaditya.app.data.model.response.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


//TODO : replace YOUR_API_KEY with apiKey that you get form https://omdbapi.com
//for better approach replace the api key to better place not here
interface ApiHelper {

    @GET("?apikey=YOUR_API_KEY")
    fun searchMovie(@Query("s") search:String,
                    @Query("type") type:String?,
                    @Query("y") year: Int?,
                    @Query("page") page: Int?
                    ) : Observable<SearchResponse>


    @GET("?apikey=YOUR_API_KEY")
    fun detailMovie(@Query("i") movieId:String, ) : Observable<MovieResponse>
}