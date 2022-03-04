package com.androiddevs.mvvmnewsapp.repository


import com.androiddevs.mvvmnewsapp.api.Retrofitinstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.ui.fragments.Article


class NewsRepository (
    val db: ArticleDatabase
    ){

    val category = ""
    suspend fun getTopHeadlines(countryCode: String, category: String, pageNumber: Int) =
        Retrofitinstance.api.getTopHeadlines(countryCode, category, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        Retrofitinstance.api.getSearchingArticles(searchQuery, pageNumber)

    suspend fun upsert(article: jsonToKt.Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: jsonToKt.Article) = db.getArticleDao().deleteArticle(article)
}