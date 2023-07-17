package com.newstask.nytimes.domain.usecase

import com.newstask.nytimes.data.model.MostPopularResponce
import com.newstask.nytimes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class NewsDataUsecase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun execute(): Flow<Response<MostPopularResponce>> {
        return newsRepository.getMostPopular()
    }

}