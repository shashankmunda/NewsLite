package com.shashankmunda.newslite.di

import com.shashankmunda.newslite.adapters.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {
    @Provides
    fun getNewsAdapter(): NewsAdapter {
        return NewsAdapter()
    }
}