package com.newstask.nytimes.presentation.articledetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.newstask.nytimes.R
import com.newstask.nytimes.data.model.NewsResultsModel
import com.newstask.nytimes.databinding.ActivityArticleDetailsBinding
import com.newstask.nytimes.presentation.base.BaseActivity
import com.newstask.nytimes.util.Constants.ARTICLES_OBJ
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailsActivity :
    BaseActivity<ActivityArticleDetailsBinding>()
{
    override val bindLayout: (LayoutInflater) -> ActivityArticleDetailsBinding
        get() = ActivityArticleDetailsBinding::inflate

    lateinit var articleDetails:NewsResultsModel
    override fun prepareView() {
        articleDetails= intent.extras?.getSerializable(ARTICLES_OBJ) as NewsResultsModel
        initUi()
    }
    private fun initUi() {
        binding.tvTitle.text=articleDetails.title
        binding.tvAuthor.text=articleDetails.byline
        binding.tvAbstract.text=articleDetails.abstract
        binding.tvDate.text=articleDetails.published_date
//        binding.tvProductNameDt.text=productdetails.title
//        binding.tvProductPriceDt.text=productdetails.price.toString() +" EGP"
//        binding.tvProductDescDtValue.text=productdetails.description
//        binding.rateProduct.rating=productdetails.rating.rate
//        Glide.with(this)
//            .load(productdetails.image)
//            .into(binding.ivProductPicDt);

    }
}

