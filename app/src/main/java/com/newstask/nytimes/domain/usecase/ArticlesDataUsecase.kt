package com.newstask.nytimes.domain.usecase

import com.newstask.nytimes.data.model.MostPopularResponce
import com.newstask.nytimes.data.model.NewsResultsModel
import com.newstask.nytimes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class ArticlesDataUsecase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun execute(): Flow<List<NewsResultsModel>>  {
        return newsRepository.getMostPopular()
    }

}