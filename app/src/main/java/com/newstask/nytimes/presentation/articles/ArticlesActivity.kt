package com.newstask.nytimes.presentation.articles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.newstask.nytimes.R
import com.newstask.nytimes.data.model.NewsResultsModel
import com.newstask.nytimes.databinding.ActivityArticlesBinding
import com.newstask.nytimes.presentation.articledetails.ArticleDetailsActivity
import com.newstask.nytimes.presentation.articles.adapters.ArticlesAdapter
import com.newstask.nytimes.presentation.base.BaseActivity
import com.newstask.nytimes.util.Constants.ARTICLES_OBJ
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class ArticlesActivity :
    BaseActivity<ActivityArticlesBinding>()
{
    override val bindLayout: (LayoutInflater) -> ActivityArticlesBinding
        get() = ActivityArticlesBinding::inflate
    private lateinit var viewModel: ArticlesListViewModel
    private lateinit var adaptercompet: ArticlesAdapter
    private fun initUi() {
        binding.rvArticles.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adaptercompet
        }
    }
    private fun onListItemClick(article:NewsResultsModel) {
        val intent = Intent(
            this,
            ArticleDetailsActivity::class.java
        )

        intent.putExtra(ARTICLES_OBJ, article)
        startActivity(intent)
    }
    override fun prepareView() {
        viewModel = ViewModelProvider(this).get(ArticlesListViewModel::class.java)
        viewModel.getArticlesList()
        adaptercompet = ArticlesAdapter(this){ code -> onListItemClick(code) }


        initUi()
        fetchCompetitions()
    }
    private fun fetchCompetitions() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is ArticlesListViewModel.ArticlesUiState.Loaded -> onLoaded(state.itemState)

                        is ArticlesListViewModel.ArticlesUiState.Error -> showError(state.message)
                        is ArticlesListViewModel.ArticlesUiState.Loading -> showLoading()
                    }
                }
            }
        }
    }
    private suspend fun onLoaded(articlesuistate: ArticlesListUiState) {
        Timber.d("showerror")

        articlesuistate.run {
            val flowOfLists: Flow<List<NewsResultsModel>> = articles
            val flatList: List<NewsResultsModel> = flowOfLists.flattenToList()
            adaptercompet.update(flatList)
            binding.paginationProgressBar.visibility = View.GONE



        }
    }



    suspend fun <T> Flow<List<T>>.flattenToList() =
        flatMapConcat { it.asFlow() }.toList()

    private fun showLoading() {
        binding. paginationProgressBar.visibility = View.VISIBLE
    }

    private fun showError(@StringRes stringRes: Int) {
        binding. paginationProgressBar.visibility = View.VISIBLE

        Toast.makeText(baseContext, stringRes, Toast.LENGTH_SHORT).show()
    }


}