package com.app.pocketnews.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.app.pocketnews.topheadlines.data.TopHeadlinesUseCase
import com.app.pocketnews.topheadlines.viewmdel.TopHeadlinesViewModel

class TopHeadlinesViewModelFactory(
    private val topHeadlinesUseCase: TopHeadlinesUseCase
) : ViewModelProvider.Factory {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            TopHeadlinesViewModel(topHeadlinesUseCase)
        }
    }
}