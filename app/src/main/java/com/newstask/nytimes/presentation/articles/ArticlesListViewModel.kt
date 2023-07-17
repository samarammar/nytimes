package com.newstask.nytimes.presentation.articles

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newstask.nytimes.data.networking.CoroutineDispatcherProvider
import com.newstask.nytimes.domain.usecase.ArticlesDataUsecase
import com.newstask.nytimes.util.ExceptionParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesListViewModel @Inject
constructor(
    private val articlesUsecase: ArticlesDataUsecase,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {



    private val _uiState = MutableStateFlow<ArticlesUiState>(ArticlesUiState.Loading)
    val uiState: StateFlow<ArticlesUiState> = _uiState


    fun getArticlesList() {
        _uiState.value = ArticlesUiState.Loading

        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            try {

                val result = articlesUsecase.execute()

                _uiState.value = ArticlesUiState.Loaded(ArticlesListUiState(result))
            } catch (error: Exception) {
                _uiState.value = ArticlesUiState.Error(ExceptionParser.getMessage(error))
            }
        }
    }

    sealed class ArticlesUiState {
        object Loading : ArticlesUiState()
        class Loaded(val itemState: ArticlesListUiState) : ArticlesUiState()
        class Error(@StringRes val message: Int) : ArticlesUiState()
    }
}



