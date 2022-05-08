package com.shashankmunda.newslite.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.shashankmunda.newslite.R
import com.shashankmunda.newslite.api.NewsAPI
import com.shashankmunda.newslite.db.ArticleDao
import com.shashankmunda.newslite.repository.NewsRepository
import com.shashankmunda.newslite.viewmodel.NewsViewModel
import com.shashankmunda.newslite.viewmodel.NewsViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    @Inject lateinit var articleDao:ArticleDao
    @Inject lateinit var api:NewsAPI
    @Inject lateinit var newsRepository:NewsRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        newsRepository = NewsRepository(articleDao,api)
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController=navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)
    }
}
