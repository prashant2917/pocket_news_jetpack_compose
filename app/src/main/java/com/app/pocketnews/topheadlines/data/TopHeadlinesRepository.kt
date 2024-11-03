package com.app.pocketnews.topheadlines.data

import com.app.pocketnews.topheadlines.data.model.TopHeadlinesNewsResponse

interface TopHeadlinesRepository {
    suspend fun getTopHeadlines(): TopHeadlinesNewsResponse
}