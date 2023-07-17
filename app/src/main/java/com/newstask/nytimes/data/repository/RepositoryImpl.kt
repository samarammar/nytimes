package com.newstask.nytimes.data.repository


import com.newstask.nytimes.data.factory.NewsFactory
import com.newstask.nytimes.data.model.MostPopularResponce
import com.newstask.nytimes.domain.repository.NewsRepository
import com.newstask.nytimes.util.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import retrofit2.http.Path
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val factory: NewsFactory
) : NewsRepository {

    override suspend fun getMostPopular(): Flow<Response<MostPopularResponce>> {
        return flow{
            emit( factory.create(Source.NETWORK).getMostPopular())
        }.flowOn(Dispatchers.IO)
    }


}