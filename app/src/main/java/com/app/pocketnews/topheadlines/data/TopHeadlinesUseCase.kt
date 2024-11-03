package com.app.pocketnews.topheadlines.data

import com.app.pocketnews.topheadlines.data.model.TopHeadlinesNewsResponse

class TopHeadlinesUseCase(private val topHeadlinesRepository: TopHeadlinesRepository) {
    suspend fun getTopHeadlines(): TopHeadlinesNewsResponse {
        return topHeadlinesRepository.getTopHeadlines()
    }
}