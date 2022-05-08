package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun fetchArticleDao(@ApplicationContext context: Context): ArticleDao {
        return ArticleDatabase.invoke(context).getArticleDao()
    }
}