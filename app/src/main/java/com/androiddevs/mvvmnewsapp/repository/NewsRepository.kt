package com.androiddevs.mvvmnewsapp.repository

import androidx.lifecycle.LiveData
import com.androiddevs.mvvmnewsapp.api.NewsAPI
import com.androiddevs.mvvmnewsapp.db.ArticleDao
import com.androiddevs.mvvmnewsapp.models.Article
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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

    fun isPresent(title: String,content: String)=articleDao.isPresent(title,content)

    suspend fun deleteArticle(article: Article) = articleDao.deleteArticle(article)
}