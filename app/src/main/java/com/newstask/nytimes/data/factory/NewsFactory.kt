package com.newstask.nytimes.data.factory

import com.newstask.nytimes.util.Source
import com.weather.weatherapp.data.source.EntityData
import com.weather.weatherapp.data.source.network.NetworkEntityData
import javax.inject.Inject

class NewsFactory  @Inject constructor(
    private val networkEntityData: NetworkEntityData
) {
    fun create(source: Source): EntityData {
        return networkEntityData

    }
}