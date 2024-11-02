package com.app.pocketnews.di

import com.app.pocketnews.network.PocketNewsApiService
import retrofit2.Retrofit

interface BaseContainer {
    val retrofit: Retrofit
    val pocketNewsApiService: PocketNewsApiService
}