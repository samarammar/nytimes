package com.newstask.nytimes.presentation.articles

import com.newstask.nytimes.data.model.NewsResultsModel
import kotlinx.coroutines.flow.Flow

data class ArticlesListUiState (
    val articles: Flow<List<NewsResultsModel>>
    )