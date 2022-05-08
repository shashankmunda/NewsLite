package com.shashankmunda.newslite.repository

import com.shashankmunda.newslite.api.NewsAPI
import com.shashankmunda.newslite.db.ArticleDao
import com.shashankmunda.newslite.models.Article
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class NewsRepository @Inject constructor(
    val articleDao: ArticleDao
    ,val apiService: NewsAPI
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        apiService.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        apiService.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = articleDao.upsert(article)

    fun getSavedNews() = articleDao.getAllArticles()

    suspend fun deleteArticle(article: Article) = articleDao.deleteArticle(article)
}