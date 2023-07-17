package com.weather.weatherapp.data.source

import com.newstask.nytimes.data.model.MostPopularResponce
import retrofit2.Response
import retrofit2.http.Path

interface EntityData {
    suspend fun getMostPopular( ): Response<MostPopularResponce>
}