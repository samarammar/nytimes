package com.newstask.nytimes.domain.repository

import com.newstask.nytimes.data.model.MostPopularResponce
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepository {
    suspend fun getMostPopular(): Flow<Response<MostPopularResponce>>
}