package com.app.pocketnews.utils

object PocketNewsConstants {

    object AppRouteConstants {
        const val ROUTE_TOP_HEADLINES = "top_headlines"
    }

    object ApiConstants {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val TOP_HEADLINES = "top-headlines"
        const val HEADER_X_API_KEY = "X-Api-Key"
        const val HEADER_X_API_KEY_VALUE = "6f5265001121423693bc90ddaf8c2672"
        const val CONNECTION_TIME_OUT = 10 * 1000L
    }
}