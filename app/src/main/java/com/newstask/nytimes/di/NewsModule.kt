package com.newstask.nytimes.di

import com.newstask.nytimes.data.repository.RepositoryImpl
import com.newstask.nytimes.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsModule {

    @Binds
    abstract fun bindNewsRepository(repository: RepositoryImpl): NewsRepository
}