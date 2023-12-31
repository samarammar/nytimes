package com.newstask.nytimes.data.api

import com.newstask.nytimes.data.model.MostPopularResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("mostpopular/v2/mostviewed/all-sections/30.json")
    suspend fun getMostPopular( @Query("api-key") api_key: String): Response<MostPopularResponce>
}

