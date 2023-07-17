package com.newstask.nytimes.domain.usecase

import com.newstask.nytimes.data.api.ApiService
import com.newstask.nytimes.data.factory.NewsFactory
import com.newstask.nytimes.data.repository.RepositoryImpl
import com.newstask.nytimes.domain.repository.NewsRepository
import com.weather.weatherapp.data.source.network.NetworkEntityData
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

 class ArticlesDataUsecaseTest{

     private lateinit var getArticlesDataUsecase: ArticlesDataUsecase
     private lateinit var repositoryImpl: RepositoryImpl
     private lateinit var factory: NewsFactory
     private lateinit var networkEntityData: NetworkEntityData

//
//     @Before
//     fun setUp(){
//
//         networkEntityData=NetworkEntityData(apiService = ApiService)
//         factory= NewsFactory()
//         repositoryImpl = RepositoryImpl()
//         getArticlesDataUsecase = ArticlesDataUsecase(newsRepository)
//     }

//
//     @Test
//     fun getArticlesListCorrect():Unit= runBlocking {
//            val article=getArticlesDataUsecase.execute()
//         ass(article.collect{
//             it.get(0).title.equals("dlvsldmv")
//         })
//     }
 }