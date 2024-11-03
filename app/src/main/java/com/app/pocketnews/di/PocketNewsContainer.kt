package com.app.pocketnews.di

import com.app.pocketnews.BuildConfig
import com.app.pocketnews.network.PocketNewsApiService
import com.app.pocketnews.topheadlines.data.TopHeadlinesRepository
import com.app.pocketnews.topheadlines.data.TopHeadlinesRepositoryImpl
import com.app.pocketnews.topheadlines.data.TopHeadlinesUseCase
import com.app.pocketnews.utils.PocketNewsConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration


object PocketNewsContainer : BaseContainer {
    override val retrofit: Retrofit by lazy {
        getRetrofitBuilder()
    }

    override val pocketNewsApiService: PocketNewsApiService by lazy {
        retrofit.create(PocketNewsApiService::class.java)
    }


    private fun getRetrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(PocketNewsConstants.ApiConstants.BASE_URL)
            .client(getOKHttpClient())
            .build()
    }

    private fun getOKHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().addNetworkInterceptor(getLoggingInterceptor())
            .connectTimeout(duration = Duration.ofMinutes(PocketNewsConstants.ApiConstants.CONNECTION_TIME_OUT))
            .build()
    }

    private fun getLoggingInterceptor(): Interceptor {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return logging

    }


    /*------------------------------------Repository ------------------------------------------------------------------------------------*/
    override val topHeadlinesRepository: TopHeadlinesRepository by lazy {
        TopHeadlinesRepositoryImpl(pocketNewsApiService)
    }


    /*-----------------------------------------UseCase------------------------------------------------------------------------------------*/
    override val topHeadlinesUseCase: TopHeadlinesUseCase by lazy {
        TopHeadlinesUseCase(topHeadlinesRepository)
    }

    /*-----------------------------------ViewModelFactory------------------------------------------------------------------------------*/

    fun provideTopHeadlinesViewModelFactory(): TopHeadlinesViewModelFactory {
        return TopHeadlinesViewModelFactory(topHeadlinesUseCase)
    }

}