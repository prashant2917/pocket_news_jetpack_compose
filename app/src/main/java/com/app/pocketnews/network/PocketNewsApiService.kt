package com.app.pocketnews.network

import com.app.pocketnews.topheadlines.data.model.TopHeadlinesNewsResponse
import com.app.pocketnews.utils.PocketNewsConstants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PocketNewsApiService {
    @GET(PocketNewsConstants.ApiConstants.TOP_HEADLINES_URL)
    suspend fun getTopHeadlines(
        @Header(PocketNewsConstants.ApiConstants.HEADER_X_API_KEY) apiKey: String?,
        @Query("country") country: String?
    ): TopHeadlinesNewsResponse
}