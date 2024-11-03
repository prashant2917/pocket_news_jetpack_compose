package com.app.pocketnews.di

import com.app.pocketnews.network.PocketNewsApiService
import com.app.pocketnews.topheadlines.data.TopHeadlinesRepository
import com.app.pocketnews.topheadlines.data.TopHeadlinesUseCase
import retrofit2.Retrofit

interface BaseContainer {
    val retrofit: Retrofit
    val pocketNewsApiService: PocketNewsApiService
    val topHeadlinesRepository: TopHeadlinesRepository
    val topHeadlinesUseCase: TopHeadlinesUseCase
}