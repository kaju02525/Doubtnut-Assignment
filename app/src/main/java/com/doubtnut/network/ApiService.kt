package com.doubtnut.network

import com.doubtnut.model.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/everything?q=bitcoin&from=2020-04-18&sortBy=publishedAt")
    fun getNewsListAsync(@Query("apiKey") apiKey:String): Deferred<Response<ApiResponse>>

}