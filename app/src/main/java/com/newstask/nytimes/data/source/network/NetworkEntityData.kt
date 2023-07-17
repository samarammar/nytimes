package com.weather.weatherapp.data.source.network


import com.newstask.nytimes.data.api.ApiService
import com.newstask.nytimes.data.model.MostPopularResponce
import com.newstask.nytimes.util.Constants
import com.weather.weatherapp.data.source.EntityData
import retrofit2.Response
import retrofit2.http.Path
import javax.inject.Inject

class NetworkEntityData  @Inject constructor(
    private val apiService: ApiService
) : EntityData {

    override suspend fun getMostPopular(): Response<MostPopularResponce> {
        return apiService.getMostPopular(Constants.API_KEY)
    }
}