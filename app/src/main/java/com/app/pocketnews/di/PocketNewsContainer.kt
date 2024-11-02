package com.app.pocketnews.di

import android.content.Context
import com.app.pocketnews.network.PocketNewsApiService
import com.app.pocketnews.network.PocketNewsInterceptor
import com.app.pocketnews.utils.PocketNewsConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

class PocketNewsContainer(context: Context) : BaseContainer {
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
        return OkHttpClient().newBuilder().addInterceptor(PocketNewsInterceptor())
            .connectTimeout(duration = Duration.ofMinutes(PocketNewsConstants.ApiConstants.CONNECTION_TIME_OUT))
            .build()
    }


}