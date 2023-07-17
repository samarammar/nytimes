package com.newstask.nytimes.presentation.articles.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newstask.nytimes.data.model.NewsResultsModel

import com.newstask.nytimes.databinding.ItemArticlesBinding

class ArticlesAdapter constructor(
    private val context: Context,private val onItemClicked: (article:NewsResultsModel) -> Unit
) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private var articlesItem: ArrayList<NewsResultsModel> = ArrayList()


    inner class ArticleViewHolder(binding: ItemArticlesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val author = binding.tvArticleAuthor
        val title = binding.tvArticleTitle
        val date = binding.tvArticleDate
        val container=binding.containerView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val viewBinding = ItemArticlesBinding.inflate(LayoutInflater.from(parent.context))
        return ArticleViewHolder(viewBinding)



    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        articlesItem[position].also {
            holder.author.text = it.byline
            holder.date.text = it.published_date
            holder.title.text=it.title
            val article=it
//         holder?.containerView?.setOnClickListener { clickListener(item, position) }
            holder.container.setOnClickListener{onItemClicked(article)}

        }
    }
    override fun getItemCount(): Int = articlesItem.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(article: List<NewsResultsModel>) {
        articlesItem.run {
            clear()
            addAll(article)
            notifyDataSetChanged()

        }
    }


}
