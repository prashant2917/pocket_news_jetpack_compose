package com.app.pocketnews.topheadlines.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class TopHeadlinesNewsResponse(

    @SerializedName("status") val status: String? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("totalResults") val totalResults: Int? = null,
    @SerializedName("articles") val articleList: List<Article>? = null,


    )

@Keep
data class Article(
    @SerializedName("source") val source: String? = null,
    @SerializedName("author") val author: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("urlToImage") val urlToImage: String? = null,
    @SerializedName("publishedAt") val publishedAt: String? = null,
    @SerializedName("content") val content: String? = null
)

@Keep
data class Source(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null
)