package com.app.pocketnews.base

import android.app.Application
import com.app.pocketnews.di.BaseContainer
import com.app.pocketnews.di.PocketNewsContainer

class PocketNewsApplication : Application() {
    lateinit var container: BaseContainer
    override fun onCreate() {
        super.onCreate()
        container = PocketNewsContainer(applicationContext)
    }

}