package com.app.pocketnews.topheadlines.data

import com.app.pocketnews.network.PocketNewsApiService
import com.app.pocketnews.topheadlines.data.model.TopHeadlinesNewsResponse
import com.app.pocketnews.utils.PocketNewsConstants
import java.util.Locale

class TopHeadlinesRepositoryImpl(private val pocketNewsApiService: PocketNewsApiService) :
    TopHeadlinesRepository {

    override suspend fun getTopHeadlines(): TopHeadlinesNewsResponse {
        return pocketNewsApiService.getTopHeadlines(
            PocketNewsConstants.ApiConstants.HEADER_X_API_KEY_VALUE,
            Locale.getDefault().country
        )
    }
}